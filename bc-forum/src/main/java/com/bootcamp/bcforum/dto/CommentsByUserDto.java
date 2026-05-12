package com.bootcamp.bcforum.dto;

import java.util.List;

public record CommentsByUserDto(
    Integer userId,
    List<CommentDto> comments) {
}
