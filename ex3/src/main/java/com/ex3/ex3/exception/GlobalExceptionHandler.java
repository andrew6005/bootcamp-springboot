package com.ex3.ex3.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ex3.ex3.model.ApiResp;


public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResp<String> handleException(Exception e) {

        return new ApiResp<>(
                "999999",
                e.getMessage(),
                null);
    }
}