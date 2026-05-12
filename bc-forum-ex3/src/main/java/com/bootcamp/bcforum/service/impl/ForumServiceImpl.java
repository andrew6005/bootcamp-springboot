package com.bootcamp.bcforum.service.impl;

import com.bootcamp.bcforum.dto.CommentCreateRequest;
import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.PostDto;
import com.bootcamp.bcforum.dto.UserDto;
import com.bootcamp.bcforum.entity.CommentEntity;
import com.bootcamp.bcforum.entity.PostEntity;
import com.bootcamp.bcforum.entity.UserEntity;
import com.bootcamp.bcforum.exception.CommentNotFoundException;
import com.bootcamp.bcforum.exception.InvalidInputException;
import com.bootcamp.bcforum.exception.PostNotFoundException;
import com.bootcamp.bcforum.exception.UserNotFoundException;
import com.bootcamp.bcforum.external.JsonComment;
import com.bootcamp.bcforum.external.JsonPost;
import com.bootcamp.bcforum.external.JsonUser;
import com.bootcamp.bcforum.mapper.ForumMapper;
import com.bootcamp.bcforum.repository.CommentRepository;
import com.bootcamp.bcforum.repository.PostRepository;
import com.bootcamp.bcforum.repository.UserRepository;
import com.bootcamp.bcforum.service.ForumService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class ForumServiceImpl implements ForumService {

  private final RestTemplate restTemplate;
  private final String baseUrl;
  private final UserRepository userRepository;
  private final PostRepository postRepository;
  private final CommentRepository commentRepository;

  public ForumServiceImpl(
      RestTemplate restTemplate,
      @Value("${jsonplaceholder.base-url}") String baseUrl,
      UserRepository userRepository,
      PostRepository postRepository,
      CommentRepository commentRepository) {
    this.restTemplate = restTemplate;
    this.baseUrl = baseUrl;
    this.userRepository = userRepository;
    this.postRepository = postRepository;
    this.commentRepository = commentRepository;
  }

  @Override
  @Transactional
  public void preloadData() {
    if (userRepository.count() > 0 || postRepository.count() > 0 || commentRepository.count() > 0) {
      return;
    }

    userRepository.saveAll(fetchList("/users", JsonUser[].class).stream()
        .map(ForumMapper::toUserEntity)
        .toList());
    postRepository.saveAll(fetchList("/posts", JsonPost[].class).stream()
        .map(ForumMapper::toPostEntity)
        .toList());
    commentRepository.saveAll(fetchList("/comments", JsonComment[].class).stream()
        .map(ForumMapper::toCommentEntity)
        .toList());
  }

  @Override
  public List<UserDto> getUsersWithPostsAndComments() {
    List<UserEntity> users = userRepository.findAll();
    List<PostEntity> posts = postRepository.findAll();
    List<CommentEntity> comments = commentRepository.findAll();

    Map<Integer, List<CommentDto>> commentsByPostId = comments.stream()
        .collect(Collectors.groupingBy(
            CommentEntity::getPostId,
            Collectors.mapping(ForumMapper::toCommentDto, Collectors.toList())));

    Map<Integer, List<PostDto>> postsByUserId = posts.stream()
        .collect(Collectors.groupingBy(
            PostEntity::getUserId,
            Collectors.mapping(
                post -> ForumMapper.toPostDto(
                    post,
                    commentsByPostId.getOrDefault(post.getId(), Collections.emptyList())),
                Collectors.toList())));

    return users.stream()
        .map(user -> ForumMapper.toUserDto(
            user,
            postsByUserId.getOrDefault(user.getId(), Collections.emptyList())))
        .toList();
  }

  @Override
  public List<CommentDto> getCommentsByUserId(Integer userId) {
    validatePositive(userId);
    if (!userRepository.existsById(userId)) {
      throw new UserNotFoundException();
    }

    List<Integer> postIds = postRepository.findByUserId(userId).stream()
        .map(PostEntity::getId)
        .toList();
    if (postIds.isEmpty()) {
      return Collections.emptyList();
    }

    return commentRepository.findByPostIdIn(postIds).stream()
        .map(ForumMapper::toCommentDto)
        .toList();
  }

  @Override
  public List<CommentDto> getCommentsByPostId(Integer postId) {
    validatePositive(postId);
    if (!postRepository.existsById(postId)) {
      throw new PostNotFoundException();
    }
    return commentRepository.findByPostId(postId).stream()
        .map(ForumMapper::toCommentDto)
        .toList();
  }

  @Override
  @Transactional
  public CommentDto addCommentByPostId(Integer postId, CommentCreateRequest request) {
    validatePositive(postId);
    if (!postRepository.existsById(postId)) {
      throw new PostNotFoundException();
    }
    if (request == null
        || !StringUtils.hasText(request.name())
        || !StringUtils.hasText(request.email())
        || !StringUtils.hasText(request.body())) {
      throw new InvalidInputException();
    }

    Integer nextId = commentRepository.findAll().stream()
        .map(CommentEntity::getId)
        .max(Integer::compareTo)
        .orElse(0) + 1;

    CommentEntity saved = commentRepository.save(new CommentEntity(
        nextId,
        postId,
        request.name(),
        request.email(),
        request.body()));
    return ForumMapper.toCommentDto(saved);
  }

  @Override
  @Transactional
  public CommentDto patchCommentBodyByCommentId(Integer commentId, String body) {
    validatePositive(commentId);
    if (!StringUtils.hasText(body)) {
      throw new InvalidInputException();
    }

    CommentEntity comment = commentRepository.findById(commentId)
        .orElseThrow(CommentNotFoundException::new);
    comment.setBody(body);
    return ForumMapper.toCommentDto(comment);
  }

  private void validatePositive(Integer id) {
    if (id == null || id <= 0) {
      throw new InvalidInputException();
    }
  }

  private <T> List<T> fetchList(String path, Class<T[]> responseType) {
    T[] response = restTemplate.getForObject(baseUrl + path, responseType);
    if (response == null) {
      return Collections.emptyList();
    }
    return Arrays.asList(response);
  }
}
