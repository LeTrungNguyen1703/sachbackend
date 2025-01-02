package com.example.identity.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(ErrorCode message) {
        super(String.valueOf(message));
    }
}
