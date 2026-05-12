package com.bootcamp.bcforum.mapper;

import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.PostDto;
import com.bootcamp.bcforum.dto.UserDto;
import com.bootcamp.bcforum.entity.CommentEntity;
import com.bootcamp.bcforum.entity.PostEntity;
import com.bootcamp.bcforum.entity.UserEntity;
import java.util.List;

public final class ForumMapper {

  private ForumMapper() {
  }

  public static CommentDto toCommentDto(CommentEntity comment) {
    return new CommentDto(comment.id(), comment.name(), comment.email(), comment.body());
  }

  public static PostDto toPostDto(PostEntity post, List<CommentDto> comments) {
    return new PostDto(post.id(), post.title(), post.body(), comments);
  }

  public static UserDto toUserDto(UserEntity user, List<PostDto> posts) {
    return new UserDto(
        user.id(),
        user.name(),
        user.username(),
        user.email(),
        user.address(),
        user.phone(),
        user.website(),
        user.company(),
        posts);
  }
}
