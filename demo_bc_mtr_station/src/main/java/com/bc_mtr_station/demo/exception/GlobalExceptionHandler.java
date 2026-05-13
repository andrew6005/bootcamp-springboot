package com.bc_mtr_station.demo.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, Object> badRequest(BadRequestException e) {
    return Map.of("code", "BAD_REQUEST", "message", e.getMessage());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String, Object> notFound(NotFoundException e) {
    return Map.of("code", "NOT_FOUND", "message", e.getMessage());
  }

  @ExceptionHandler(UpstreamException.class)
  @ResponseStatus(HttpStatus.BAD_GATEWAY)
  public Map<String, Object> upstream(UpstreamException e) {
    return Map.of("code", "UPSTREAM_ERROR", "message", e.getMessage());
  }
}