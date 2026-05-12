package com.bootcamp.bcforum.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.PostDto;
import com.bootcamp.bcforum.dto.UserDto;
import com.bootcamp.bcforum.exception.GlobalExceptionHandler;
import com.bootcamp.bcforum.exception.UserNotFoundException;
import com.bootcamp.bcforum.service.ForumService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class ForumControllerTest {

  private ForumService forumService;
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    forumService = org.mockito.Mockito.mock(ForumService.class);
    mockMvc = MockMvcBuilders
        .standaloneSetup(new ForumController(forumService))
        .setControllerAdvice(new GlobalExceptionHandler())
        .build();
  }

  @Test
  void getUsersWithPostsAndCommentsReturnsNestedData() throws Exception {
    CommentDto comment = new CommentDto(1, "name", "email@test.com", "body");
    PostDto post = new PostDto(1, "title", "body", List.of(comment));
    UserDto user = new UserDto(1, "Leanne Graham", "Bret", "test@test.com",
        null, "123", "site.com", null, List.of(post));

    when(forumService.getUsersWithPostsAndComments()).thenReturn(List.of(user));

    mockMvc.perform(get("/forum/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id").value(1))
        .andExpect(jsonPath("$[0].posts[0].comments[0].email").value("email@test.com"));
  }

  @Test
  void getCommentsByUserIdReturnsWrappedComments() throws Exception {
    when(forumService.getCommentsByUserId(1))
        .thenReturn(List.of(new CommentDto(1, "name", "email@test.com", "body")));

    mockMvc.perform(get("/forum/comments").param("userId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.userId").value(1))
        .andExpect(jsonPath("$.comments", hasSize(1)));
  }

  @Test
  void getCommentsByUserIdReturnsInvalidInputForNonNumber() throws Exception {
    mockMvc.perform(get("/forum/comments").param("userId", "abc"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value(2))
        .andExpect(jsonPath("$.message").value("Invalid Input."));
  }

  @Test
  void getCommentsByUserIdReturnsUserNotFound() throws Exception {
    when(forumService.getCommentsByUserId(999)).thenThrow(new UserNotFoundException());

    mockMvc.perform(get("/forum/comments").param("userId", "999"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.code").value(1))
        .andExpect(jsonPath("$.message").value("User not found."));
  }
}
