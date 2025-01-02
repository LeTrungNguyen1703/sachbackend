package com.example.identity.dto.response;

public class ApiResponseError extends ApiResponseData {

    public ApiResponseError(int status, String message) {
        super(status, message);
    }
}
