package com.example.identity.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    SUCCESS(1000, "Success", HttpStatus.OK),
    USER_ALREADY_EXISTS(1010, "User already exists",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1011, "User not found", HttpStatus.NOT_FOUND),
    INVALID_KEY(1001, "Invalid message key", HttpStatus.BAD_REQUEST),
    RUNTIME_EXCEPTION(1002, "Runtime exception", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters long", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004, "Password must be at least {min} characters long", HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_MATCH(1005, "Password not match", HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_NULL(1005, "Password must not be null",HttpStatus.BAD_REQUEST),
    TOKEN_NOT_NULL(1020, "Token must not be null", HttpStatus.BAD_REQUEST),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.BAD_REQUEST),
    PARSE_TOKEN_EXCEPTION(1007, "PARSE_TOKEN_EXCEPTION", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(1008, "You do not have permission", HttpStatus.FORBIDDEN),
    UNAUTHENTICATED(1021, "You do not have permission", HttpStatus.FORBIDDEN),
    THE_LOAI_NOT_FOUND(1030, "Khong co the loai nay", HttpStatus.BAD_REQUEST),
    THE_LOAI_ALREADY_EXITS(1031, "Khong the tao the loai da ton tai", HttpStatus.BAD_REQUEST),
    ROLE_NOT_FOUND(1032, "ROLE KHONG TON TAI", HttpStatus.BAD_REQUEST),
    SACH_NOT_FOUND(1033, "SACH KHONG TON TAI", HttpStatus.BAD_REQUEST),
    NOT_FOUND(1034, "KHONG TON TAI", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_FAILED(1006, "Authentication failed", HttpStatus.UNAUTHORIZED),
    INVALID_DOB(1021, "Your age must be at least {min}", HttpStatus.BAD_REQUEST),
    MISSING_PARAMETER(1020,"Need Parameter for this request", HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatusCode statusCode;

}
