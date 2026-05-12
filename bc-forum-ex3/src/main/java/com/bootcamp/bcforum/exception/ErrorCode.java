package com.bootcamp.bcforum.exception;

public enum ErrorCode {
  SUCCESS("000000", "Success."),
  USER_NOT_FOUND("000001", "User not found."),
  POST_NOT_FOUND("000002", "Post not found."),
  COMMENT_NOT_FOUND("000003", "Comment not found."),
  INVALID_INPUT("000004", "Invalid Input."),
  JSONPLACEHOLDER_ERROR("999998", "Json PlaceHolder API unavailable."),
  GENERAL_ERROR("999999", "Unexpected error.");

  private final String code;
  private final String message;

  ErrorCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
