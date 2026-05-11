package com.ex3.ex3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    private Long id;

    private Long postId;

    private String name;

    private String email;

    @Column(columnDefinition = "TEXT")
    private String body;

    public CommentEntity() {
    }

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