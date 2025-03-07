package com.example.identity.service.Impl;

import com.example.identity.dto.request.SuDanhGia.SuDanhGiaRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.entity.Sach;
import com.example.identity.entity.SuDanhGia;
import com.example.identity.entity.TheLoai;
import com.example.identity.entity.User;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceAlreadyExitsException;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.mapper.SuDanhGiaMapper;
import com.example.identity.mapper.TheLoaiMapper;
import com.example.identity.methodsPhoBien.ServiceHelper;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.SuDanhGiaRepository;
import com.example.identity.repository.TheLoaiRepository;
import com.example.identity.repository.UserRepository;
import com.example.identity.service.SuDanhGiaService;
import com.example.identity.service.TheLoaiService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class SuDanhGiaServiceImpl implements SuDanhGiaService {

    SuDanhGiaRepository suDanhGiaRepository;
    SuDanhGiaMapper suDanhGiaMapper;
    SachRepository sachRepository;
    UserRepository userRepository;
    ServiceHelper serviceHelper;

    @Override
    public SuDanhGiaResponse createSuDanhGia(SuDanhGiaRequest request) {

        SuDanhGia suDanhGia = suDanhGiaMapper.toSuDanhGia(request);

        Sach sach = serviceHelper.getSachById(request.getSach());
        User user = serviceHelper.getUserById(request.getUser());

        suDanhGia.setSach(sach);
        suDanhGia.setUser(user);

        suDanhGiaRepository.save(suDanhGia);

        SuDanhGiaResponse suDanhGiaResponse = suDanhGiaMapper.toSachDanhGiaResponse(suDanhGia);

        return suDanhGiaMapper.toSachDanhGiaResponse(suDanhGia);
    }

    @Override
    public List<SuDanhGiaResponse> getSuDanhGias() {
        return List.of();
    }

    @Override
    public SuDanhGiaResponse getSuDanhGiaById(int id) {
        return null;
    }

    @Override
    public SuDanhGiaResponse updateSuDanhGia(int Id, SuDanhGiaRequest request) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
