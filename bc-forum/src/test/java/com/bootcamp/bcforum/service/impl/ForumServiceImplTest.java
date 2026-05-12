package com.bootcamp.bcforum.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.UserDto;
import com.bootcamp.bcforum.entity.CommentEntity;
import com.bootcamp.bcforum.entity.PostEntity;
import com.bootcamp.bcforum.entity.UserEntity;
import com.bootcamp.bcforum.exception.InvalidInputException;
import com.bootcamp.bcforum.exception.UserNotFoundException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class ForumServiceImplTest {

  private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

  private RestTemplate restTemplate;
  private ForumServiceImpl forumService;

  @BeforeEach
  void setUp() {
    restTemplate = org.mockito.Mockito.mock(RestTemplate.class);
    forumService = new ForumServiceImpl(restTemplate, BASE_URL);
  }

  @Test
  void getUsersWithPostsAndCommentsMapsNestedLists() {
    mockUsers(new UserEntity(1, "User One", "user1", "user1@test.com",
        null, "123", "site.com", null));
    mockPosts(new PostEntity(1, 10, "post", "body"));
    mockComments(new CommentEntity(10, 100, "comment", "comment@test.com", "body"));

    List<UserDto> users = forumService.getUsersWithPostsAndComments();

    assertEquals(1, users.size());
    assertEquals(1, users.getFirst().posts().size());
    assertEquals(1, users.getFirst().posts().getFirst().comments().size());
    assertEquals("comment@test.com",
        users.getFirst().posts().getFirst().comments().getFirst().email());
  }

  @Test
  void getCommentsByUserIdReturnsOnlyCommentsForThatUsersPosts() {
    mockUsers(
        new UserEntity(1, "User One", "user1", "user1@test.com", null, "123", "site.com", null),
        new UserEntity(2, "User Two", "user2", "user2@test.com", null, "123", "site.com", null));
    mockPosts(
        new PostEntity(1, 10, "post 10", "body"),
        new PostEntity(2, 20, "post 20", "body"));
    mockComments(
        new CommentEntity(10, 100, "comment 100", "one@test.com", "body"),
        new CommentEntity(20, 200, "comment 200", "two@test.com", "body"));

    List<CommentDto> comments = forumService.getCommentsByUserId(1);

    assertEquals(1, comments.size());
    assertEquals(100, comments.getFirst().id());
  }

  @Test
  void getCommentsByUserIdThrowsInvalidInput() {
    assertThrows(InvalidInputException.class, () -> forumService.getCommentsByUserId(0));
  }

  @Test
  void getCommentsByUserIdThrowsUserNotFound() {
    mockUsers(new UserEntity(1, "User One", "user1", "user1@test.com",
        null, "123", "site.com", null));

    assertThrows(UserNotFoundException.class, () -> forumService.getCommentsByUserId(999));
  }

  private void mockUsers(UserEntity... users) {
    when(restTemplate.getForObject(BASE_URL + "/users", UserEntity[].class)).thenReturn(users);
  }

  private void mockPosts(PostEntity... posts) {
    when(restTemplate.getForObject(BASE_URL + "/posts", PostEntity[].class)).thenReturn(posts);
  }

  private void mockComments(CommentEntity... comments) {
    when(restTemplate.getForObject(BASE_URL + "/comments", CommentEntity[].class)).thenReturn(comments);
  }
}
