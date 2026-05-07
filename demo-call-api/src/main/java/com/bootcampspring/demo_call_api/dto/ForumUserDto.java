package com.bootcampspring.demo_call_api.dto;

public class ForumUserDto {

    private String email;
    private String phone;
    private String username;

    public ForumUserDto(String email, String phone, String username) {
        this.email = email;
        this.phone = phone;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }
}