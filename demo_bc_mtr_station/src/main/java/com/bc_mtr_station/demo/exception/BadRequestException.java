package com.bc_mtr_station.demo.exception;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) { super(message); }
}