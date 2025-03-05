package com.example.identity.service.Impl;

import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.entity.Sach;
import com.example.identity.entity.TheLoai;
import com.example.identity.mapper.TheLoaiMapper;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.TheLoaiRepository;
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
public class TheLoaiServiceImpl implements TheLoaiService {

    TheLoaiRepository theLoaiRepository;
    TheLoaiMapper theLoaiMapper;
    SachRepository sachRepository;

    @Override
    public TheLoaiResponse createTheLoai(TheLoaiRequest request) {
        TheLoai theLoai = theLoaiMapper.toTheLoai(request);

        theLoaiRepository.save(theLoai);

        return theLoaiMapper.toTheLoaiResponse(theLoai);
    }

    @Override
    public PageResponse<List<TheLoaiResponse>> getTheLoais(int pageNo, int pageSize, String sortBy) {
        return null;
    }

    @Override
    public TheLoaiResponse getTheLoaiById(String id) {
        return null;
    }

    @Override
    public TheLoaiResponse updateTheLoai(String Id, TheLoaiUpdateRequest request) {
        return null;
    }
}
