package com.example.identity.dto.response.Sach;

import com.example.identity.dto.request.HInhAnh.HinhAnhRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class SachResponse {

    private String tenSach;

    private String tenTacGia;

    private String ISBN;

    private String moTa;

    private double giaNiemYet;

    private double giaBan;

    private int soLuong;

    private Double trungBinhXepHang;

    List<String> danhSachTheLoai;

    List<HinhAnhRequest> danhSachHinhAnh;
}
