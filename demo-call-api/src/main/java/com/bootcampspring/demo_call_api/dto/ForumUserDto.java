package com.bootcampspring.demo_call_api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
 @Builder
public class ForumUserDto {

 private String email;
    private String phone;
    private String username;

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