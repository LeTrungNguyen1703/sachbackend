package com.example.identity.controller;

import com.example.identity.dto.request.HInhAnh.HinhAnhRequest;
import com.example.identity.dto.request.HInhAnh.HinhAnhUpdateRequest;
import com.example.identity.dto.request.SuDanhGia.SuDanhGiaRequest;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.HinhAnh.HinhAnhResponse;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaResponse;
import com.example.identity.exception.ErrorCode;
import com.example.identity.service.HinhAnhService;
import com.example.identity.service.SuDanhGiaService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/hinh-anh")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HinhAnhController {
    HinhAnhService hinhAnhService;

    @PostMapping
    public ApiResponseData<HinhAnhResponse> createHinhAnh(@RequestParam(value = "idSach", required = false) Integer idSach ,@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return new ApiResponseData<>(hinhAnhService.createHinhAnh(idSach, file));
    }

    @GetMapping
    public ApiResponseData<List<HinhAnhResponse>> getAllHinhAnh() {
        return new ApiResponseData<>(hinhAnhService.getHinhAnhs());
    }

    @GetMapping("/get")
    public ApiResponseData<HinhAnhResponse> getHinhAnhById(
            @RequestParam(required = false) Integer id
    ) {
        if (id != null) {
            return new ApiResponseData<>(hinhAnhService.getHinhAnhById(id));
        } 
        throw (new IllegalArgumentException(ErrorCode.MISSING_PARAMETER.getMessage()));
    }

    @PutMapping("/{id}")
    public void updateHinhAnh(@RequestBody HinhAnhUpdateRequest request, @PathVariable int id) {
        hinhAnhService.updateHinhAnh(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteHinhAnhById(@PathVariable int id) {
        hinhAnhService.delete(id);
    }

}
