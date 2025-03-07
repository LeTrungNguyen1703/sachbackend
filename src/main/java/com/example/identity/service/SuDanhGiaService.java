package com.example.identity.service;

import com.example.identity.dto.request.SuDanhGia.SuDanhGiaRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;

import java.util.List;

public interface SuDanhGiaService {

    SuDanhGiaResponse createSuDanhGia(SuDanhGiaRequest request);
    List<SuDanhGiaResponse> getSuDanhGias();
    SuDanhGiaResponse getSuDanhGiaById(int id);
    SuDanhGiaResponse updateSuDanhGia(int Id, SuDanhGiaRequest request);
    void delete(int id);
}
