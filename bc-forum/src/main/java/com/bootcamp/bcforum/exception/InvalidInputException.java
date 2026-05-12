package com.bootcamp.bcforum.exception;

public class InvalidInputException extends RuntimeException {

  public InvalidInputException() {
    super(ErrorCode.INVALID_INPUT.getMessage());
  }
}
