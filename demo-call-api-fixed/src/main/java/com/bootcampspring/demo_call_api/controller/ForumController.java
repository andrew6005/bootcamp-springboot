package com.bootcampspring.demo_call_api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcampspring.demo_call_api.dto.ForumUserDto;
import com.bootcampspring.demo_call_api.entity.UserEntity;
import com.bootcampspring.demo_call_api.model.UserDto;
import com.bootcampspring.demo_call_api.service.ForumService;

@RestController
@RequestMapping("/api")
public class ForumController {
  @Autowired
  private ForumService forumService;

  @GetMapping(value = "/users")
  public List<ForumUserDto> getUsers() {
    List<ForumUserDto> forumUserDtos = new ArrayList<>();
    List<UserDto> userDtos = this.forumService.getUsers();

    for (UserDto userDto : userDtos) {
      ForumUserDto forumUserDto = new ForumUserDto();
      forumUserDto.setEmail(userDto.getEmail());
      forumUserDto.setPhone(userDto.getPhone());
      forumUserDto.setUsername(userDto.getUsername());
      forumUserDtos.add(forumUserDto);
    }

    return forumUserDtos;
  }

  @PostMapping(value = "/users")
  public List<UserEntity> storeUsers() {
    return this.forumService.insertUsers();
  }
}
