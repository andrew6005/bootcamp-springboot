package com.ex3.ex3.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ex3.ex3.dto.PostDto;
import com.ex3.ex3.entity.PostEntity;
import com.ex3.ex3.repository.PostRepository;


@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // GET all posts
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // GET posts by user id
    public List<PostDto> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId)
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // POST new post by user id
    public PostDto addPostByUserId(Long userId, PostEntity post) {
        post.setUserId(userId);

        PostEntity savedPost = postRepository.save(post);

        return entityToDto(savedPost);
    }

    // DELETE post by id
    public void deletePostById(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new RuntimeException("Post not found");
        }

        postRepository.deleteById(postId);
    }

    // Entity -> DTO
    private PostDto entityToDto(PostEntity entity) {
        return new PostDto(
                entity.getId(),
                entity.getUserId(),
                entity.getTitle(),
                entity.getBody()
        );
    }
}