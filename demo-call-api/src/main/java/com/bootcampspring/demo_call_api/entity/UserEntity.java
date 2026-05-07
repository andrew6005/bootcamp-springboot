package com.bootcampspring.demo_call_api.entity;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import com.bootcampspring.demo_call_api.dto.ForumUserDto;
import com.bootcampspring.demo_call_api.service.ForumService;

public class UserEntity {
  private ForumService forumService;
 @PostMapping(value = "/DB")
  public List<ForumUserDto> postser() {

    return this.forumService.getUsers().stream() //
        .map(e -> {
          return ForumUserDto.builder() //
              .email(e.getEmail()) //
              .phone(e.getPhone()) //
              .username(e.getUsername()) //
              .build();
        }).collect(Collectors.toList());
  }

  @PostMapping(value = "/DB")
  public List<ForumUserDto> getter() {

    return this.forumService.getUsers().stream() //
        .map(e -> {
          return ForumUserDto.builder() //
              .email(e.getEmail()) //
              .phone(e.getPhone()) //
              .username(e.getUsername()) //
              .build();
        }).collect(Collectors.toList());
  }



}
