package com.bootcamp.bcforum.entity;

public record CommentEntity(
    Integer postId,
    Integer id,
    String name,
    String email,
    String body) {
}
