package com.bootcamp.bcforum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity {

  @Id
  private Integer id;
  private Integer postId;
  private String name;
  private String email;

  @Column(length = 4000)
  private String body;

  public CommentEntity() {
  }

  public CommentEntity(Integer id, Integer postId, String name, String email, String body) {
    this.id = id;
    this.postId = postId;
    this.name = name;
    this.email = email;
    this.body = body;
  }

  public Integer getId() {
    return id;
  }

  public Integer getPostId() {
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

  public void setBody(String body) {
    this.body = body;
  }
}
