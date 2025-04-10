package com.example.identity.service;

import com.example.identity.dto.request.Sach.SachRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.Sach.SachResponse;

import java.util.List;

public interface SachService {
    SachResponse createSach(SachRequest request);
    PageResponse<List<SachResponse>> getSachs(int pageNo, int pageSize, String sortBy);
    SachResponse getSachByName(String name);
    SachResponse getSachById(Integer name);
    void updateSach(int id,SachRequest request);
    void deleteSach(Integer Id);
    void avgDanhGia();
    void chooseIcon(int idImg, int idSach);
    PageResponse<List<SachResponse>> searchSach(String tenSach, int pageNo, int pageSize);
}
