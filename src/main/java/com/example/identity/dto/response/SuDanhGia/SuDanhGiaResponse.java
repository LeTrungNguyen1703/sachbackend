package com.example.identity.dto.response.SuDanhGia;

import com.example.identity.dto.response.Sach.SachResponse;
import com.example.identity.dto.response.User.UserResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SuDanhGiaResponse {
    private long maDanhGia;

    private Float diemXepHang;

    private String nhanXet;

    private SachResponse sach;

    private UserResponseDTO user;
}
