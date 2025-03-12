package com.example.identity.service;

import com.example.identity.dto.request.SuDanhGia.SuDanhGiaRequest;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaProjection;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaResponse;

import java.util.List;

public interface SuDanhGiaService {

    SuDanhGiaResponse createSuDanhGia(SuDanhGiaRequest request);
    List<SuDanhGiaResponse> getSuDanhGias();
    SuDanhGiaResponse getSuDanhGiaById(long id);
    void updateSuDanhGia(long id, SuDanhGiaRequest request);
    void delete(long id);

}
