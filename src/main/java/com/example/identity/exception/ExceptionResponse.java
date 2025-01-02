package com.example.identity.exception;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ExceptionResponse {

    int code;               // Mã trạng thái 
    String message;         // Thông điệp về lỗi
    String path;            // Đường dẫn URL nơi lỗi xảy ra
    Date timestamp;
}
