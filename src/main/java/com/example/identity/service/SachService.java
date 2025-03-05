package com.example.identity.service;

import com.example.identity.dto.request.Sach.SachRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.Sach.SachResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.repository.SachRepository;

import java.util.List;

public interface SachService {
    SachRepository createSach(SachRequest request);
    PageResponse<List<SachResponse>> getSachs(int pageNo, int pageSize, String sortBy);
    SachResponse getSachById(String id);
    SachResponse updateSach(String Id, SachRequest request);
}
