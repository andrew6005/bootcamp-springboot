package com.pcforum_ex.demo_pcforum_ex.dto;

public class CommentDto {
    private Long id;
    private String name;
    private String email;
    private String body;

    public CommentDto() {
    }

    public CommentDto(Long id, String name, String email, String body) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
