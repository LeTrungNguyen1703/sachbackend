package com.example.identity.service;

import com.example.identity.dto.request.HInhAnh.HinhAnhUpdateRequest;
import com.example.identity.dto.response.HinhAnh.HinhAnhResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HinhAnhService {

    HinhAnhResponse createHinhAnh(Integer idSach,MultipartFile file) throws IOException;
    List<HinhAnhResponse> getHinhAnhs();
    HinhAnhResponse getHinhAnhById(Integer id);
    void updateHinhAnh(Integer id, HinhAnhUpdateRequest request);
    void delete(Integer id);
}
