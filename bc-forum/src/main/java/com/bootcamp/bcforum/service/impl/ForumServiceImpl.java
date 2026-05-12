package com.bootcamp.bcforum.service.impl;

import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.PostDto;
import com.bootcamp.bcforum.dto.UserDto;
import com.bootcamp.bcforum.entity.CommentEntity;
import com.bootcamp.bcforum.entity.PostEntity;
import com.bootcamp.bcforum.entity.UserEntity;
import com.bootcamp.bcforum.exception.InvalidInputException;
import com.bootcamp.bcforum.exception.UserNotFoundException;
import com.bootcamp.bcforum.mapper.ForumMapper;
import com.bootcamp.bcforum.service.ForumService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ForumServiceImpl implements ForumService {

  private final RestTemplate restTemplate;
  private final String baseUrl;

  public ForumServiceImpl(
      RestTemplate restTemplate,
      @Value("${jsonplaceholder.base-url}") String baseUrl) {
    this.restTemplate = restTemplate;
    this.baseUrl = baseUrl;
  }

  @Override
  public List<UserDto> getUsersWithPostsAndComments() {
    List<UserEntity> users = fetchList("/users", UserEntity[].class);
    List<PostEntity> posts = fetchList("/posts", PostEntity[].class);
    List<CommentEntity> comments = fetchList("/comments", CommentEntity[].class);

    Map<Integer, List<CommentDto>> commentsByPostId = comments.stream()
        .filter(comment -> comment.postId() != null)
        .collect(Collectors.groupingBy(
            CommentEntity::postId,
            Collectors.mapping(ForumMapper::toCommentDto, Collectors.toList())));

    Map<Integer, List<PostDto>> postsByUserId = posts.stream()
        .filter(post -> post.userId() != null)
        .collect(Collectors.groupingBy(
            PostEntity::userId,
            Collectors.mapping(
                post -> ForumMapper.toPostDto(
                    post,
                    commentsByPostId.getOrDefault(post.id(), Collections.emptyList())),
                Collectors.toList())));

    return users.stream()
        .map(user -> ForumMapper.toUserDto(
            user,
            postsByUserId.getOrDefault(user.id(), Collections.emptyList())))
        .toList();
  }

  @Override
  public List<CommentDto> getCommentsByUserId(Integer userId) {
    if (userId == null || userId <= 0) {
      throw new InvalidInputException();
    }

    List<UserEntity> users = fetchList("/users", UserEntity[].class);
    boolean userExists = users.stream()
        .map(UserEntity::id)
        .anyMatch(id -> Objects.equals(id, userId));

    if (!userExists) {
      throw new UserNotFoundException();
    }

    List<PostEntity> posts = fetchList("/posts", PostEntity[].class);
    List<Integer> postIds = posts.stream()
        .filter(post -> Objects.equals(post.userId(), userId))
        .map(PostEntity::id)
        .toList();

    if (postIds.isEmpty()) {
      return Collections.emptyList();
    }

    Map<Integer, Boolean> postIdLookup = postIds.stream()
        .collect(Collectors.toMap(Function.identity(), id -> true));

    return fetchList("/comments", CommentEntity[].class).stream()
        .filter(comment -> postIdLookup.containsKey(comment.postId()))
        .map(ForumMapper::toCommentDto)
        .toList();
  }

  private <T> List<T> fetchList(String path, Class<T[]> responseType) {
    T[] response = restTemplate.getForObject(baseUrl + path, responseType);
    if (response == null) {
      return Collections.emptyList();
    }
    return Arrays.asList(response);
  }
}
