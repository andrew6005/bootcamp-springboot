package com.bootcamp.bcforum.exception;

import com.bootcamp.bcforum.dto.ApiResp;
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
  public ResponseEntity<ApiResp<Void>> handleUserNotFound(UserNotFoundException exception) {
    return build(ErrorCode.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(PostNotFoundException.class)
  public ResponseEntity<ApiResp<Void>> handlePostNotFound(PostNotFoundException exception) {
    return build(ErrorCode.POST_NOT_FOUND, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(CommentNotFoundException.class)
  public ResponseEntity<ApiResp<Void>> handleCommentNotFound(CommentNotFoundException exception) {
    return build(ErrorCode.COMMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
      InvalidInputException.class,
      MissingServletRequestParameterException.class,
      MethodArgumentTypeMismatchException.class
  })
  public ResponseEntity<ApiResp<Void>> handleInvalidInput(Exception exception) {
    return build(ErrorCode.INVALID_INPUT, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RestClientException.class)
  public ResponseEntity<ApiResp<Void>> handleRestClient(RestClientException exception) {
    return build(ErrorCode.JSONPLACEHOLDER_ERROR, HttpStatus.SERVICE_UNAVAILABLE);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResp<Void>> handleException(Exception exception) {
    return build(ErrorCode.GENERAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<ApiResp<Void>> build(ErrorCode errorCode, HttpStatus status) {
    return ResponseEntity
        .status(status)
        .body(ApiResp.error(errorCode.getCode(), errorCode.getMessage()));
  }
}
