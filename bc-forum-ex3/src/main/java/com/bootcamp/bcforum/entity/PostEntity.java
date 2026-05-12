package com.bootcamp.bcforum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class PostEntity {

  @Id
  private Integer id;
  private Integer userId;
  private String title;

  @Column(length = 4000)
  private String body;

  public PostEntity() {
  }

  public PostEntity(Integer id, Integer userId, String title, String body) {
    this.id = id;
    this.userId = userId;
    this.title = title;
    this.body = body;
  }

  public Integer getId() {
    return id;
  }

  public Integer getUserId() {
    return userId;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }
}
