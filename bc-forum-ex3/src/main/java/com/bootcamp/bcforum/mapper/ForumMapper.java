package com.bootcamp.bcforum.mapper;

import com.bootcamp.bcforum.dto.AddressDto;
import com.bootcamp.bcforum.dto.CommentDto;
import com.bootcamp.bcforum.dto.CompanyDto;
import com.bootcamp.bcforum.dto.GeoDto;
import com.bootcamp.bcforum.dto.PostDto;
import com.bootcamp.bcforum.dto.UserDto;
import com.bootcamp.bcforum.entity.CommentEntity;
import com.bootcamp.bcforum.entity.PostEntity;
import com.bootcamp.bcforum.entity.UserEntity;
import com.bootcamp.bcforum.external.JsonComment;
import com.bootcamp.bcforum.external.JsonPost;
import com.bootcamp.bcforum.external.JsonUser;
import java.util.List;

public final class ForumMapper {

  private ForumMapper() {
  }

  public static UserEntity toUserEntity(JsonUser user) {
    JsonUser.Address address = user.address();
    JsonUser.Geo geo = address == null ? null : address.geo();
    JsonUser.Company company = user.company();
    return new UserEntity(
        user.id(),
        user.name(),
        user.username(),
        user.email(),
        user.phone(),
        user.website(),
        address == null ? null : address.street(),
        address == null ? null : address.suite(),
        address == null ? null : address.city(),
        address == null ? null : address.zipcode(),
        geo == null ? null : geo.lat(),
        geo == null ? null : geo.lng(),
        company == null ? null : company.name(),
        company == null ? null : company.catchPhrase(),
        company == null ? null : company.bs());
  }

  public static PostEntity toPostEntity(JsonPost post) {
    return new PostEntity(post.id(), post.userId(), post.title(), post.body());
  }

  public static CommentEntity toCommentEntity(JsonComment comment) {
    return new CommentEntity(
        comment.id(),
        comment.postId(),
        comment.name(),
        comment.email(),
        comment.body());
  }

  public static CommentDto toCommentDto(CommentEntity comment) {
    return new CommentDto(comment.getId(), comment.getName(), comment.getEmail(), comment.getBody());
  }

  public static PostDto toPostDto(PostEntity post, List<CommentDto> comments) {
    return new PostDto(post.getId(), post.getTitle(), post.getBody(), comments);
  }

  public static UserDto toUserDto(UserEntity user, List<PostDto> posts) {
    AddressDto address = new AddressDto(
        user.getStreet(),
        user.getSuite(),
        user.getCity(),
        user.getZipcode(),
        new GeoDto(user.getLat(), user.getLng()));
    CompanyDto company = new CompanyDto(
        user.getCompanyName(),
        user.getCatchPhrase(),
        user.getBs());
    return new UserDto(
        user.getId(),
        user.getName(),
        user.getUsername(),
        user.getEmail(),
        address,
        user.getPhone(),
        user.getWebsite(),
        company,
        posts);
  }
}
