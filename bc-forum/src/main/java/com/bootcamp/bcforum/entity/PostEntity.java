package com.bootcamp.bcforum.entity;

public record PostEntity(
    Integer userId,
    Integer id,
    String title,
    String body) {
}
