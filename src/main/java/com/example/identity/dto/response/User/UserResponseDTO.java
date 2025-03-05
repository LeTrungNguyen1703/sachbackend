package com.example.identity.dto.response.User;

import com.example.identity.dto.response.RoleResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponseDTO {

    String ten;
    String hoDem;
    String tenDangNhap;
    char gioiTinh;
    String email;
    String soDienThoai;
    Set<RoleResponse> danhSachQuyen;
}
