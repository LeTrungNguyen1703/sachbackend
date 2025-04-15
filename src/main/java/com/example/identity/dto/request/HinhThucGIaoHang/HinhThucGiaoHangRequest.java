package com.example.identity.dto.request.HinhThucGIaoHang;

import com.example.identity.entity.DonHang;
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
public class HinhThucGiaoHangRequest {
    private Integer maHinhThucGiaoHang;
    private String tenHinhThucGiaoHang;
    private String moTa;
    private Double chiPhiGiaoHang;
}
