package com.bootcamp.bcforum.service;

import com.bootcamp.bcforum.dto.CommentCreateRequest;
import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.UserDto;
import java.util.List;

public interface ForumService {

  void preloadData();

  List<UserDto> getUsersWithPostsAndComments();

  List<CommentDto> getCommentsByUserId(Integer userId);

  List<CommentDto> getCommentsByPostId(Integer postId);

  CommentDto addCommentByPostId(Integer postId, CommentCreateRequest request);

  CommentDto patchCommentBodyByCommentId(Integer commentId, String body);
}
