package com.bootcamp.bcforum.dto;

import java.util.List;

public record PostDto(
    Integer id,
    String title,
    String body,
    List<CommentDto> comments) {
}
