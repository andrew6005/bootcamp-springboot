package com.pcforum_ex.demo_pcforum_ex.dto;

public class ErrorResponse {
    private int code;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message) {
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
