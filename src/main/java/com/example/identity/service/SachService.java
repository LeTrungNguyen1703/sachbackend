package com.example.identity.service;

import com.example.identity.dto.request.Sach.SachRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.Sach.SachResponse;

import java.util.List;

public interface SachService {
    SachResponse createSach(SachRequest request);
    PageResponse<List<SachResponse>> getSachs(int pageNo, int pageSize, String sortBy);
    SachResponse getSachById(String id);
    void updateSach(int id,SachRequest request);
    void deleteSach(Integer Id);
    void avgDanhGia();
}
