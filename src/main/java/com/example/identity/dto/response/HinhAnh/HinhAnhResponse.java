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

    private String tenHinhAnh;

    private byte[] duLieuAnh;

    private boolean laIcon;
}
