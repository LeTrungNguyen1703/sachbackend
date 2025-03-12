package com.example.identity.dto.request.Sach;

import com.example.identity.dto.request.HInhAnh.HinhAnhRequest;
import com.example.identity.entity.*;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class SachRequest {

    private String tenSach;

    private String tenTacGia;

    private String ISBN;

    private String moTa;

    private double giaNiemYet;

    private double giaBan;

    private int soLuong;

    List<String> danhSachTheLoai;

//    List<Integer> danhSachHinhAnh;


}
