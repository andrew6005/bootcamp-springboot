package com.pcforum_ex.demo_pcforum_ex.dto;

import java.util.List;

public class UserCommentsDto {
    private Long id;
    private String username;
    private List<CommentDto> comments;

    public UserCommentsDto() {
    }

    public UserCommentsDto(Long id, String username, List<CommentDto> comments) {
        this.id = id;
        this.username = username;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<CommentDto> getComments() {
        return comments;
    }
}
