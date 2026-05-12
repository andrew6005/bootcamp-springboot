package com.bootcamp.bcforum.exception;

import com.bootcamp.bcforum.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponseDto> handleUserNotFound(UserNotFoundException exception) {
    return build(ErrorCode.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
      InvalidInputException.class,
      MissingServletRequestParameterException.class,
      MethodArgumentTypeMismatchException.class
  })
  public ResponseEntity<ErrorResponseDto> handleInvalidInput(Exception exception) {
    return build(ErrorCode.INVALID_INPUT, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RestClientException.class)
  public ResponseEntity<ErrorResponseDto> handleRestTemplate(RestClientException exception) {
    return build(ErrorCode.REST_TEMPLATE_ERROR, HttpStatus.SERVICE_UNAVAILABLE);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDto> handleException(Exception exception) {
    return build(ErrorCode.GENERAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<ErrorResponseDto> build(ErrorCode errorCode, HttpStatus status) {
    return ResponseEntity
        .status(status)
        .body(new ErrorResponseDto(errorCode.getCode(), errorCode.getMessage()));
  }
}
