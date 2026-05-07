package com.bootcampspring.demo_call_api.controller;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.bootcampspring.demo_call_api.dto.ForumUserDto;

import com.bootcampspring.demo_call_api.service.ForumService;




@Service
public class ForumController {
  @Autowired
  private ForumService forumService;

  @GetMapping(value = "/users")
  public List<ForumUserDto> getUsers() {
    // List<Apple> -> List<Banana>
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