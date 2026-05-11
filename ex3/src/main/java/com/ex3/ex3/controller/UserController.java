package com.ex3.ex3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import com.ex3.ex3.entity.UserEntity;
import com.ex3.ex3.model.ApiResp;
import com.ex3.ex3.service.UserService;




@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ApiResp<List<UserEntity>> getUsers() {

        return new ApiResp<>(
                "000000",
                "Success.",
                userService.getAllUsers());
    }

    @GetMapping("/id")
    public ApiResp<UserEntity> getUser(
            @RequestParam Long id) {

        return new ApiResp<>(
                "000000",
                "Success.",
                userService.getUser(id));
    }

    @PutMapping("/{id}")
    public ApiResp<UserEntity> updateUser(
            @PathVariable Long id,
            @RequestBody UserEntity user) {

        return new ApiResp<>(
                "000000",
                "Updated.",
                userService.updateUser(id, user));
    }
}