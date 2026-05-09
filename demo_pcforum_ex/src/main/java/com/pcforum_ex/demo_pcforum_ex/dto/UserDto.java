package com.pcforum_ex.demo_pcforum_ex.dto;

import java.util.List;

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private List<PostDto> posts;

    public UserDto() {
    }

    public UserDto(Long id, String username, String email, List<PostDto> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<PostDto> getPosts() {
        return posts;
    }
}
