package com.example.identity.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private final String MIN_ATTRIBUTE = "min";

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ExceptionResponse> handleRuntimeException(HttpServletRequest request) {
        var exception = ExceptionResponse.builder()
                .code(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode())
                .message(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage())
                .path(request.getRequestURI())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RuntimeException.class,IllegalArgumentException.class})
    public ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        var runtimeException = ExceptionResponse.builder()
                .code(ErrorCode.RUNTIME_EXCEPTION.getCode())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(runtimeException, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({ResourceAlreadyExitsException.class, ResourceNotFoundException.class, AuthenticatedException.class})
    public ResponseEntity<ExceptionResponse> handleResourceAlreadyExitsException(Exception e, HttpServletRequest request) {
        String enumKey = e.getMessage();
        ErrorCode errorCode = this.errorCodeKeyToErrorCode(enumKey);

        log.error("Error: {}", errorCode.getMessage(), e.getCause());

        var exception = ExceptionResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .path(request.getRequestURI())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(exception, errorCode.getStatusCode());
    }

    @ExceptionHandler({ParseException.class})
    public ResponseEntity<ExceptionResponse> handleParseTokenException(ParseException e, HttpServletRequest request) {
        String errorMessage = "Parse token failed";
        log.error("Error: {}", errorMessage, e.getCause());

        var exception = ExceptionResponse.builder()
                .code(ErrorCode.PARSE_TOKEN_EXCEPTION.getCode())
                .message(errorMessage)
                .path(request.getRequestURI())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ExceptionResponse> handleValidationException(MethodArgumentNotValidException e, HttpServletRequest request) {
        ErrorCode errorCode = this.errorCodeKeyToErrorCode(e.getFieldError().getDefaultMessage());

        Map<String, Object> attributes = this.getAttributes(e, errorCode);

        var exception = ExceptionResponse.builder()
                .code(errorCode.getCode())
                .message((attributes != null)
                        ? this.mapAttributes(errorCode.getMessage(), attributes)
                        : errorCode.getMessage())
                .path(request.getRequestURI())
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(exception, errorCode.getStatusCode());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        log.error("Error: {}", e.getMessage(), e.getCause());
        var errorCode = ErrorCode.UNAUTHORIZED;

        var exception = ExceptionResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .path(request.getRequestURI())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(exception, errorCode.getStatusCode());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest request) {
        log.error("Error: {}", e.getMessage(), e.getCause());
        var errorCode = ErrorCode.MISSING_PARAMETER;

        var exception = ExceptionResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .path(request.getRequestURI())
                .timestamp(new Date())
                .build();
        return new ResponseEntity<>(exception, errorCode.getStatusCode());
    }

    // Helper methods------------------------------------------------------------
    private ErrorCode errorCodeKeyToErrorCode(String enumKey) {
        ErrorCode errorCode = ErrorCode.INVALID_KEY;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException ex) {
            log.error("Invalid message key: {}", enumKey);
        }
        return errorCode;
    }

    private Map<String, Object> getAttributes(MethodArgumentNotValidException e, ErrorCode errorCode) {
        Map<String,Object> attributes = null;
        try {

            var constraintViolations = e.getBindingResult().getAllErrors()
                    .get(0).unwrap(ConstraintViolation.class);

            attributes = constraintViolations.getConstraintDescriptor().getAttributes();
        } catch (IllegalArgumentException ex) {
            log.error("Invalid message key: {}", errorCode.getMessage());
        }
        return attributes;
    }

    private String mapAttributes(String message, Map<String, Object> attributes) {
        String minValue =  String.valueOf(attributes.get(MIN_ATTRIBUTE));
        return message.replace("{" + MIN_ATTRIBUTE + "}", minValue);
    }


}
