package com.ex3.ex3.dto;

public class CommentDto {

    private Long id;

    private Long postId;

    private String name;

    private String email;

    private String body;

    // Empty constructor
    public CommentDto() {
    }

    // All arguments constructor
    public CommentDto(Long id,
                      Long postId,
                      String name,
                      String email,
                      String body) {

        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    // Getter methods
    public Long getId() {
        return id;
    }

    public Long getPostId() {
        return postId;
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

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBody(String body) {
        this.body = body;
    }
}