package com.example.identity.dto.request.SuDanhGia;

import com.example.identity.dto.request.HInhAnh.HinhAnhRequest;
import com.example.identity.entity.Sach;
import com.example.identity.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class SuDanhGiaRequest {

    private Float diemXepHang;

    private String nhanXet;

    private Integer sach;

    private Integer user;
    

}
