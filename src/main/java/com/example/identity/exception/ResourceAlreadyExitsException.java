package com.example.identity.exception;

public class ResourceAlreadyExitsException extends RuntimeException {
    public ResourceAlreadyExitsException(ErrorCode message) {
        super(String.valueOf(message));
    }
}
