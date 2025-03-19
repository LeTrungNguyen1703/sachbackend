package com.example.identity.service.Impl;

import com.example.identity.dto.request.HInhAnh.HinhAnhUpdateRequest;
import com.example.identity.dto.response.HinhAnh.HinhAnhResponse;
import com.example.identity.entity.HinhAnh;
import com.example.identity.entity.Sach;
import com.example.identity.mapper.HinhAnhMapper;
import com.example.identity.methodsPhoBien.ServiceHelper;
import com.example.identity.repository.HinhAnhRepository;
import com.example.identity.service.HinhAnhService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class HinhAnhServiceImpl implements HinhAnhService {

    HinhAnhMapper hinhAnhMapper;
    HinhAnhRepository hinhAnhRepository;
    ServiceHelper serviceHelper;

    @Override
    public HinhAnhResponse createHinhAnh(Integer idSach, MultipartFile file) throws IOException {
        Sach sach = serviceHelper.getSachById(idSach);

        String enCode = Base64.getEncoder().encodeToString(file.getBytes());

        HinhAnh hinhAnh = new HinhAnh();
        hinhAnh.setTenHinhAnh(file.getOriginalFilename());
        hinhAnh.setDuongDan(file.getContentType());
        hinhAnh.setDuLieuAnh(enCode);
        hinhAnh.setSach(sach);

        hinhAnhRepository.save(hinhAnh);

        return hinhAnhMapper.toHinhAnhResponse(hinhAnh);
    }

    @Override
    public List<HinhAnhResponse> getHinhAnhs() {
        List<HinhAnh> hinhAnhs = hinhAnhRepository.findAll();

        return hinhAnhs.stream().map(hinhAnhMapper::toHinhAnhResponse).collect(Collectors.toList());
    }

    @Override
    public HinhAnhResponse getHinhAnhById(Integer id) {
        HinhAnh hinhAnh = serviceHelper.getHinhAnhById(id);
        byte[] imageDecode = Base64.getDecoder().decode(hinhAnh.getDuLieuAnh());

        HinhAnhResponse hinhAnhResponse = hinhAnhMapper.toHinhAnhResponse(hinhAnh);
        hinhAnhResponse.setDuLieuAnh(imageDecode);

        return hinhAnhResponse;
    }

    @Override
    public void updateHinhAnh(Integer id, HinhAnhUpdateRequest request) {

    }

    @Override
    public void delete(Integer id) {

    }
}
