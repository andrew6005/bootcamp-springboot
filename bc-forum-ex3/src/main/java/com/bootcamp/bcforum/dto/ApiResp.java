package com.bootcamp.bcforum.dto;

public record ApiResp<T>(String code, String message, T data) {

  public static <T> ApiResp<T> success(T data) {
    return new ApiResp<>("000000", "Success.", data);
  }

  public static <T> ApiResp<T> error(String code, String message) {
    return new ApiResp<>(code, message, null);
  }
}
