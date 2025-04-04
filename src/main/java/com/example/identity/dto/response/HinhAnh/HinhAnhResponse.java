package com.example.identity.dto.response.HinhAnh;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class HinhAnhResponse {
    private int maHinhAnh;

    private String tenHinhAnh;

    private String duongDan;

    private String duLieuAnh;

    private boolean laIcon;
}
