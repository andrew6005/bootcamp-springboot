package com.bootcamp.bcforum.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bootcamp.bcforum.dto.CommentCreateRequest;
import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.exception.GlobalExceptionHandler;
import com.bootcamp.bcforum.exception.PostNotFoundException;
import com.bootcamp.bcforum.service.ForumService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
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
  void getCommentsByPostIdReturnsApiResp() throws Exception {
    when(forumService.getCommentsByPostId(1))
        .thenReturn(List.of(new CommentDto(1, "name", "email@test.com", "body")));

    mockMvc.perform(get("/forum/comments/by-post").param("postId", "1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code").value("000000"))
        .andExpect(jsonPath("$.data", hasSize(1)));
  }

  @Test
  void addCommentReturnsApiResp() throws Exception {
    when(forumService.addCommentByPostId(any(Integer.class), any(CommentCreateRequest.class)))
        .thenReturn(new CommentDto(501, "name", "email@test.com", "body"));

    mockMvc.perform(post("/forum/comments")
            .param("postId", "1")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\":\"name\",\"email\":\"email@test.com\",\"body\":\"body\"}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.id").value(501));
  }

  @Test
  void patchCommentBodyReturnsApiResp() throws Exception {
    when(forumService.patchCommentBodyByCommentId(1, "new body"))
        .thenReturn(new CommentDto(1, "name", "email@test.com", "new body"));

    mockMvc.perform(patch("/forum/comments/body")
            .param("commentId", "1")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"body\":\"new body\"}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.data.body").value("new body"));
  }

  @Test
  void notFoundReturnsApiRespError() throws Exception {
    when(forumService.getCommentsByPostId(999)).thenThrow(new PostNotFoundException());

    mockMvc.perform(get("/forum/comments/by-post").param("postId", "999"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.code").value("000002"))
        .andExpect(jsonPath("$.data").doesNotExist());
  }
}
