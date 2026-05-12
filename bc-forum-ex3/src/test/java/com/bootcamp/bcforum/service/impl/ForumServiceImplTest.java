package com.bootcamp.bcforum.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.bootcamp.bcforum.dto.CommentCreateRequest;
import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.entity.CommentEntity;
import com.bootcamp.bcforum.entity.PostEntity;
import com.bootcamp.bcforum.exception.PostNotFoundException;
import com.bootcamp.bcforum.repository.CommentRepository;
import com.bootcamp.bcforum.repository.PostRepository;
import com.bootcamp.bcforum.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

class ForumServiceImplTest {

  private PostRepository postRepository;
  private CommentRepository commentRepository;
  private ForumServiceImpl forumService;

  @BeforeEach
  void setUp() {
    RestTemplate restTemplate = org.mockito.Mockito.mock(RestTemplate.class);
    UserRepository userRepository = org.mockito.Mockito.mock(UserRepository.class);
    postRepository = org.mockito.Mockito.mock(PostRepository.class);
    commentRepository = org.mockito.Mockito.mock(CommentRepository.class);
    forumService = new ForumServiceImpl(
        restTemplate,
        "https://jsonplaceholder.typicode.com",
        userRepository,
        postRepository,
        commentRepository);
  }

  @Test
  void getCommentsByPostIdMapsComments() {
    when(postRepository.existsById(1)).thenReturn(true);
    when(commentRepository.findByPostId(1))
        .thenReturn(List.of(new CommentEntity(1, 1, "name", "email@test.com", "body")));

    List<CommentDto> comments = forumService.getCommentsByPostId(1);

    assertEquals(1, comments.size());
    assertEquals("email@test.com", comments.getFirst().email());
  }

  @Test
  void getCommentsByPostIdThrowsWhenPostMissing() {
    when(postRepository.existsById(999)).thenReturn(false);

    assertThrows(PostNotFoundException.class, () -> forumService.getCommentsByPostId(999));
  }

  @Test
  void addCommentByPostIdCreatesNextId() {
    when(postRepository.existsById(1)).thenReturn(true);
    when(commentRepository.findAll())
        .thenReturn(List.of(new CommentEntity(500, 1, "old", "old@test.com", "old")));
    when(commentRepository.save(org.mockito.ArgumentMatchers.any(CommentEntity.class)))
        .thenAnswer(invocation -> invocation.getArgument(0));

    CommentDto comment = forumService.addCommentByPostId(
        1,
        new CommentCreateRequest("new", "new@test.com", "body"));

    assertEquals(501, comment.id());
  }

  @Test
  void patchCommentBodyUpdatesBody() {
    CommentEntity comment = new CommentEntity(1, 1, "name", "email@test.com", "old");
    when(commentRepository.findById(1)).thenReturn(Optional.of(comment));

    CommentDto patched = forumService.patchCommentBodyByCommentId(1, "new");

    assertEquals("new", patched.body());
  }
}
