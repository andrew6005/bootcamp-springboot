package com.pcforum_ex.demo_pcforum_ex.service;

import org.springframework.stereotype.Service;
import com.pcforum_ex.demo_pcforum_ex.dto.CommentDto;
import com.pcforum_ex.demo_pcforum_ex.dto.PostDto;
import com.pcforum_ex.demo_pcforum_ex.dto.UserCommentsDto;
import com.pcforum_ex.demo_pcforum_ex.dto.UserDto;
import com.pcforum_ex.demo_pcforum_ex.entity.CommentEntity;
import com.pcforum_ex.demo_pcforum_ex.entity.PostEntity;
import com.pcforum_ex.demo_pcforum_ex.entity.UserEntity;
import com.pcforum_ex.demo_pcforum_ex.exception.InvalidInputException;
import com.pcforum_ex.demo_pcforum_ex.exception.UserNotFoundException;
import com.pcforum_ex.demo_pcforum_ex.repository.CommentRepository;
import com.pcforum_ex.demo_pcforum_ex.repository.PostRepository;
import com.pcforum_ex.demo_pcforum_ex.repository.UserRepository;
import java.util.List;

@Service
public class ForumService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public ForumService(UserRepository userRepository,
                        PostRepository postRepository,
                        CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public List<UserDto> getAllUsersWithPostsAndComments() {
        List<UserEntity> users = userRepository.findAll();
        List<PostEntity> posts = postRepository.findAll();
        List<CommentEntity> comments = commentRepository.findAll();

        return users.stream()
                .map(user -> new UserDto(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        posts.stream()
                                .filter(post -> post.getUserId().equals(user.getId()))
                                .map(post -> new PostDto(
                                        post.getId(),
                                        post.getTitle(),
                                        post.getBody(),
                                        comments.stream()
                                                .filter(comment -> comment.getPostId().equals(post.getId()))
                                                .map(this::toCommentDto)
                                                .toList()
                                ))
                                .toList()
                ))
                .toList();
    }

    public UserCommentsDto getCommentsByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new InvalidInputException();
        }

        List<UserEntity> users = userRepository.findAll();
        UserEntity user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);

        List<Long> postIds = postRepository.findAll().stream()
                .filter(post -> post.getUserId().equals(userId))
                .map(PostEntity::getId)
                .toList();

        List<CommentDto> comments = commentRepository.findAll().stream()
                .filter(comment -> postIds.contains(comment.getPostId()))
                .map(this::toCommentDto)
                .toList();

        return new UserCommentsDto(user.getId(), user.getUsername(), comments);
    }

    private CommentDto toCommentDto(CommentEntity comment) {
        return new CommentDto(
                comment.getId(),
                comment.getName(),
                comment.getEmail(),
                comment.getBody()
        );
    }
}
