package com.example.identity.dto.request.TheLoai;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TheLoaiUpdateRequest {

    private String tenTheLoai;
    private List<String> danhSachQuyenSach;
}
