package com.example.identity.service.Impl;

import com.example.identity.dto.request.KhuyenMai.KhuyenMaiRequest;
import com.example.identity.dto.request.KhuyenMai.KhuyenMaiUpdateRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.KhuyenMai.KhuyenMaiResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.entity.KhuyenMai;
import com.example.identity.entity.TheLoai;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceAlreadyExitsException;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.mapper.KhuyenMaiMapper;
import com.example.identity.mapper.TheLoaiMapper;
import com.example.identity.repository.KhuyenMaiRepository;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.TheLoaiRepository;
import com.example.identity.service.KhuyenMaiService;
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
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    KhuyenMaiRepository khuyenMaiRepository;
    KhuyenMaiMapper khuyenMaiMapper;

    @Override
    public KhuyenMaiResponse createKhuyenMai(KhuyenMaiRequest request) {
        KhuyenMai khuyenMai = khuyenMaiMapper.toKhuyenMai(request);
        if (khuyenMaiRepository.findByTenKhuyenMai(request.getTenKhuyenMai()).isPresent()) {
            throw (new ResourceAlreadyExitsException(ErrorCode.ALREADY_EXITS));
        }

        khuyenMai = khuyenMaiRepository.save(khuyenMai);

        return khuyenMaiMapper.toKhuyenMaiResponse(khuyenMai);
    }

    @Override
    public List<KhuyenMaiResponse> getKhuyenMais() {
        List<KhuyenMai> khuyenMai = khuyenMaiRepository.findAll();

        return khuyenMai.stream()
                .map(khuyenMaiMapper::toKhuyenMaiResponse)
                .collect(Collectors.toList());
    }

    @Override
    public KhuyenMaiResponse getKhuyenMaiById(int id) {
        KhuyenMai khuyenMai = khuyenMaiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.NOT_FOUND));

        return khuyenMaiMapper.toKhuyenMaiResponse(khuyenMai);
    }

   @Override
   public KhuyenMaiResponse getKhuyenMaiByTenKhuyenMai(String tenKhuyenMai) {

       KhuyenMai khuyenMai = (KhuyenMai) khuyenMaiRepository.findByTenKhuyenMai(tenKhuyenMai)
               .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.NOT_FOUND));

       return khuyenMaiMapper.toKhuyenMaiResponse(khuyenMai);
   }

    @Override
    public KhuyenMaiResponse updateKhuyenMai(int id, KhuyenMaiUpdateRequest request) {
        KhuyenMai khuyenMai = khuyenMaiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.NOT_FOUND));

        khuyenMaiMapper.updateKhuyenMai(request, khuyenMai);

        khuyenMaiRepository.save(khuyenMai);
        return khuyenMaiMapper.toKhuyenMaiResponse(khuyenMai);
    }

    @Override
    public void delete(int id) {
       khuyenMaiRepository.deleteById(id);
    }


}
