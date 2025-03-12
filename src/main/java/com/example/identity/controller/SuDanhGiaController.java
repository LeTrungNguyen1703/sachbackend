package com.example.identity.controller;

import com.example.identity.dto.request.SuDanhGia.SuDanhGiaRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaProjection;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.exception.ErrorCode;
import com.example.identity.service.SuDanhGiaService;
import com.example.identity.service.TheLoaiService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/su-danh-gia")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SuDanhGiaController {
    SuDanhGiaService suDanhGiaService;

    @PostMapping
    public ApiResponseData<SuDanhGiaResponse> createSuDanhGia(@RequestBody @Valid SuDanhGiaRequest request) {

        return new ApiResponseData<>(suDanhGiaService.createSuDanhGia(request));
    }

    @GetMapping
    public ApiResponseData<List<SuDanhGiaResponse>> getAllSuDanhGia() {

        return new ApiResponseData<>(suDanhGiaService.getSuDanhGias());
    }

    @GetMapping("/get")
    public ApiResponseData<SuDanhGiaResponse> getSuDanhGiaById(
            @RequestParam(required = false) Integer id
    ) {

        if (id != null) {
            return new ApiResponseData<>(suDanhGiaService.getSuDanhGiaById(id));
        } 
        throw (new IllegalArgumentException(ErrorCode.MISSING_PARAMETER.getMessage()));
    }

    @PutMapping("/{id}")
    public void updateSuDanhGia(@RequestBody SuDanhGiaRequest request, @PathVariable int id) {
        suDanhGiaService.updateSuDanhGia(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteSuDanhGiaById(@PathVariable int id) {
        suDanhGiaService.delete(id);

    }

}
