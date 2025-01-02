package com.example.identity.exception;

public class AuthenticatedException extends RuntimeException {
    public AuthenticatedException(ErrorCode message) {
        super(String.valueOf(message));
    }
}
