package com.example.identity.dto.response.TheLoai;

import com.example.identity.dto.response.Sach.SachResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TheLoaiResponse {
    private int maTheLoai;
    private String tenTheLoai;
}
