package com.example.identity.dto.response;

import com.example.identity.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ApiResponseData<T> {
    private int code = ErrorCode.SUCCESS.getCode();
    private String message = ErrorCode.SUCCESS.getMessage();
    private T result;

    public ApiResponseData(T data) {
        this.result = data;
    }

    public ApiResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
