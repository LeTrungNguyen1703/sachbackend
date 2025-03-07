package com.example.identity.dto.response.HinhAnh;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class HinhAnhResponse {

    private Float diemXepHang;

    private String nhanXet;

    private String sach;

    private String user;
}
