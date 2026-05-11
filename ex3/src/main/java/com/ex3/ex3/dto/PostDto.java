package com.ex3.ex3.dto;

public class PostDto {

    private Long id;

    private Long userId;

    private String title;

    private String body;

    // Empty constructor
    public PostDto() {
    }

    // All arguments constructor
    public PostDto(Long id,
                   Long userId,
                   String title,
                   String body) {

        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    // Getter methods
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    // Setter methods
    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}