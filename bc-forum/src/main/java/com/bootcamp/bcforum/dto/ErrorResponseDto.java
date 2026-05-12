package com.bootcamp.bcforum.dto;

public record ErrorResponseDto(
    Integer code,
    String message) {
}
