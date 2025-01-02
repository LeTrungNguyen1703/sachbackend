package com.example.identity.exception;

public class AppException extends RuntimeException {
    public AppException(ErrorCode message) {
        super(String.valueOf(message));
    }
}
