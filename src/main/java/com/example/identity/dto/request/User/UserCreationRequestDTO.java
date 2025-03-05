package com.example.identity.dto.request.User;

import com.example.identity.entity.DonHang;
import com.example.identity.entity.Role;
import com.example.identity.entity.SachYeuThich;
import com.example.identity.entity.SuDanhGia;
import com.example.identity.validator.DobConstraint;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserCreationRequestDTO {

    private String ten;
    private String hoDem;
    @Size(min = 3, message = "USERNAME_INVALID")
    private String tenDangNhap;
    @NotNull(message = "PASSWORD_NOT_NULL")
    @Size(min = 8, message = "PASSWORD_INVALID")
    private String matKhau;
    private char gioiTinh;
    private String email;
    private String soDienThoai;
    private String diaChiMuaHang;
    private String diaChiGiaoHang;
    private List<String> danhSachQuyen;

}