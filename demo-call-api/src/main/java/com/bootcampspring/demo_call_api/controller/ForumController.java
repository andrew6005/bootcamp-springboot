package com.bootcampspring.demo_call_api.controller;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcampspring.demo_call_api.dto.ForumUserDto;
import com.bootcampspring.demo_call_api.entity.UserEntity;

import com.bootcampspring.demo_call_api.repository.UserRepository;
import com.bootcampspring.demo_call_api.service.ForumService;

@RestController
public class ForumController {

    private final UserRepository userRepository;

    @Autowired
    private ForumService forumService;

    public ForumController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<ForumUserDto> getUsers() {
        return this.forumService.getUsers().stream()
                .map(e -> new ForumUserDto(
                        e.getEmail(),
                        e.getPhone(),
                        e.getUsername()
                ))
                .collect(Collectors.toList());
    }
    // List<ForumUserDto> forumUserDtos = new ArrayList<>();
    // List<UserDto> userDtos = this.forumService.getUsers(); 
    // for(UserDto userDto :userDtos){
    //     ForumUserDto forumUserDto = ForumUserDto.builder()
    //     .getEmail(userDto.getEmail())
    //     .phone(userDto.getPhone())
    //     .username(userDto.getUsername())
    //     .build();
    //     forumUserDtos.add(forumUserDto);

    // }
    // return forumUserDtos



    @PostMapping("/usersupdate")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }
}