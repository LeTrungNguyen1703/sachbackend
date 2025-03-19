package com.example.identity.dto.request.HInhAnh;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class HinhAnhUpdateRequest {
    private String tenHinhAnh;

    private boolean laIcon;

    private String duongDan;

    private String duLieuAnh;

}
