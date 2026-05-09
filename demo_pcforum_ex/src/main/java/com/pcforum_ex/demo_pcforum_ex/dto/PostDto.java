package com.pcforum_ex.demo_pcforum_ex.dto;

import java.util.List;

public class PostDto {
    private Long id;
    private String title;
    private String body;
    private List<CommentDto> comments;

    public PostDto() {
    }

    public PostDto(Long id, String title, String body, List<CommentDto> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public List<CommentDto> getComments() {
        return comments;
    }
}
