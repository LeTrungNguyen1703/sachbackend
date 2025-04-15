package com.example.identity.service;

import com.example.identity.dto.request.KhuyenMai.KhuyenMaiRequest;
import com.example.identity.dto.request.KhuyenMai.KhuyenMaiUpdateRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.KhuyenMai.KhuyenMaiResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;

import java.util.List;

public interface KhuyenMaiService {
    KhuyenMaiResponse createKhuyenMai(KhuyenMaiRequest request);
    List<KhuyenMaiResponse> getKhuyenMais();
    KhuyenMaiResponse getKhuyenMaiById(int id);
    KhuyenMaiResponse getKhuyenMaiByTenKhuyenMai(String tenKhuyenMai);
    KhuyenMaiResponse updateKhuyenMai(int id, KhuyenMaiUpdateRequest request);
    void delete(int id);
}
