package com.bootcamp.bcforum.controller;

import com.bootcamp.bcforum.dto.ApiResp;
import com.bootcamp.bcforum.dto.CommentBodyPatchRequest;
import com.bootcamp.bcforum.dto.CommentCreateRequest;
import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.UserDto;
import com.bootcamp.bcforum.entity.PostEntity;
import com.bootcamp.bcforum.repository.PostRepository;
import com.bootcamp.bcforum.service.ForumService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forum")
public class ForumController {

  private final ForumService forumService;

  public ForumController(ForumService forumService) {
    this.forumService = forumService;
  }

  @GetMapping("/users")
  public ApiResp<List<UserDto>> getUsersWithPostsAndComments() {
    return ApiResp.success(forumService.getUsersWithPostsAndComments());
  }

  @GetMapping("/comments/by-user")
  public ApiResp<List<CommentDto>> getCommentsByUserId(@RequestParam Integer userId) {
    return ApiResp.success(forumService.getCommentsByUserId(userId));
  }

  @GetMapping("/comments/by-post")
  public ApiResp<List<CommentDto>> getCommentsByPostId(@RequestParam Integer postId) {
    return ApiResp.success(forumService.getCommentsByPostId(postId));
  }

  @PostMapping("/comments")
  public ApiResp<CommentDto> addCommentByPostId(
      @RequestParam Integer postId,
      @RequestBody CommentCreateRequest request) {
    return ApiResp.success(forumService.addCommentByPostId(postId, request));
  }

  @PatchMapping("/comments/body")
  public ApiResp<CommentDto> patchCommentBodyByCommentId(
      @RequestParam Integer commentId,
      @RequestBody CommentBodyPatchRequest request) {
    return ApiResp.success(forumService.patchCommentBodyByCommentId(commentId, request.body()));
  }
}