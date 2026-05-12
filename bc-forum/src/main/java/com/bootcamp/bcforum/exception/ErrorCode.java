package com.bootcamp.bcforum.exception;

public enum ErrorCode {
  USER_NOT_FOUND(1, "User not found."),
  INVALID_INPUT(2, "Invalid Input."),
  REST_TEMPLATE_ERROR(3, "RestTemplate Error - JsonPlaceHolder."),
  GENERAL_ERROR(99, "Unexpected error.");

  private final int code;
  private final String message;

  ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
