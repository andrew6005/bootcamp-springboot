package com.pcforum_ex.demo_pcforum_ex.entity;

public class CommentEntity {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;

    public CommentEntity() {
    }

    public Long getPostId() {
        return postId;
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

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setId(Long id) {
        this.id = id;
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
