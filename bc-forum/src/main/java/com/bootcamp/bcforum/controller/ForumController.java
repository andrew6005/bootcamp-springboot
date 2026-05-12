package com.bootcamp.bcforum.controller;

import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.CommentsByUserDto;
import com.bootcamp.bcforum.dto.UserDto;
import com.bootcamp.bcforum.service.ForumService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum")
public class ForumController {

  private final ForumService forumService;

  public ForumController(ForumService forumService) {
    this.forumService = forumService;
  }

  @GetMapping("/users")
  public List<UserDto> getUsersWithPostsAndComments() {
    return forumService.getUsersWithPostsAndComments();
  }

  @GetMapping("/comments")
  public CommentsByUserDto getCommentsByUserId(@RequestParam Integer userId) {
    List<CommentDto> comments = forumService.getCommentsByUserId(userId);
    return new CommentsByUserDto(userId, comments);
  }
}
