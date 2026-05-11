package com.ex3.ex3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    private Long id;

    private Long userId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    public PostEntity() {
    }

    public PostEntity(Long id, Long userId,
                      String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

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