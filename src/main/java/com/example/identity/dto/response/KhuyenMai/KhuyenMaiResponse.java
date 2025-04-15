package com.example.identity.dto.response.KhuyenMai;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class KhuyenMaiResponse {

    private int id;

    private String tenKhuyenMai;

    private String mieuTa;

    private Double phanTramGiam;

    private Date ngayBatDau;

    private Date ngayKetThuc;

}
