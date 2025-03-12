package com.example.identity.dto.response.User;

import com.example.identity.dto.response.RoleResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {

    String ten;
    String hoDem;
    String tenDangNhap;
    char gioiTinh;
    String email;
    String soDienThoai;
    Set<RoleResponse> danhSachQuyen;
}
