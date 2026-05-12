package com.bootcamp.bcforum.service;

import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.UserDto;
import java.util.List;

public interface ForumService {

  List<UserDto> getUsersWithPostsAndComments();

  List<CommentDto> getCommentsByUserId(Integer userId);
}
