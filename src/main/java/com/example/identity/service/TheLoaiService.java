package com.example.identity.service;

import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;

import java.util.List;

public interface TheLoaiService {
    TheLoaiResponse createTheLoai(TheLoaiRequest request);
    List<TheLoaiResponse> getTheLoais();
    TheLoaiResponse getTheLoaiById(int id);
    TheLoaiResponse getTheLoaiByTenTheLoai(String tenTheLoai);
    TheLoaiResponse updateTheLoai(int Id, TheLoaiUpdateRequest request);
    void delete(int id);
}
