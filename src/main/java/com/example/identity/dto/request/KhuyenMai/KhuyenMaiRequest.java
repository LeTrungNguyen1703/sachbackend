package com.example.identity.dto.request.KhuyenMai;

import com.example.identity.entity.ChiPhiGiaoHang;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class KhuyenMaiRequest {

    private String tenKhuyenMai;

    private String mieuTa;

    private Double phanTramGiam;

    private Date ngayBatDau;

    private Date ngayKetThuc;

}
