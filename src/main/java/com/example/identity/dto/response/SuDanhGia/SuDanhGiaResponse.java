package com.example.identity.dto.response.SuDanhGia;

import com.example.identity.dto.response.Sach.SachResponse;
import com.example.identity.dto.response.User.UserResponseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class SuDanhGiaResponse {

    private Float diemXepHang;

    private String nhanXet;

    private SachResponse sach;

    private UserResponseDTO user;
}
