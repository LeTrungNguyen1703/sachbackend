package com.example.identity.dto.request.KhuyenMai;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class KhuyenMaiUpdateRequest {

    private String tenKhuyenMai;

    private String mieuTa;

    private Double phanTramGiam;

    private Date ngayBatDau;

    private Date ngayKetThuc;

}
