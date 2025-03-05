package com.example.identity.service.Impl;

import com.example.identity.dto.request.Sach.SachRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.Sach.SachResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.entity.TheLoai;
import com.example.identity.mapper.TheLoaiMapper;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.TheLoaiRepository;
import com.example.identity.service.SachService;
import com.example.identity.service.TheLoaiService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class SachServiceImpl implements SachService {

    @Override
    public SachRepository createSach(SachRequest request) {
        return null;
    }

    @Override
    public PageResponse<List<SachResponse>> getSachs(int pageNo, int pageSize, String sortBy) {
        return null;
    }

    @Override
    public SachResponse getSachById(String id) {
        return null;
    }

    @Override
    public SachResponse updateSach(String Id, SachRequest request) {
        return null;
    }
}
