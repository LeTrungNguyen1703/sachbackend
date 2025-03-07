package com.example.identity.dto.response.TheLoai;

import com.example.identity.dto.response.Sach.SachResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TheLoaiResponse {

    private String tenTheLoai;
}
