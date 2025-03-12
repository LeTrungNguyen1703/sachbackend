package com.example.identity.dto.response.Sach;

import com.example.identity.dto.request.HInhAnh.HinhAnhRequest;
import com.example.identity.dto.response.HinhAnh.HinhAnhResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SachResponse {

    private String tenSach;

    private String tenTacGia;

    private String ISBN;

    private String moTa;

    private double giaNiemYet;

    private double giaBan;

    private int soLuong;

    private Double trungBinhXepHang;

    List<TheLoaiResponse> danhSachTheLoai;

//    List<HinhAnhResponse> danhSachHinhAnh; // chua xong
}
