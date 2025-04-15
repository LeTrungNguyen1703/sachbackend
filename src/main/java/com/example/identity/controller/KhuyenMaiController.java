package com.example.identity.controller;

import com.example.identity.dto.request.KhuyenMai.KhuyenMaiRequest;
import com.example.identity.dto.request.KhuyenMai.KhuyenMaiUpdateRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.KhuyenMai.KhuyenMaiResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.exception.ErrorCode;
import com.example.identity.service.KhuyenMaiService;
import com.example.identity.service.TheLoaiService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/khuyen-mai")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KhuyenMaiController {
    KhuyenMaiService khuyenMaiService;

    @PostMapping
    public ApiResponseData<KhuyenMaiResponse> createKhuyenMai(@RequestBody @Valid KhuyenMaiRequest request) {

        return new ApiResponseData<>(khuyenMaiService.createKhuyenMai(request));
    }

    @GetMapping
    public ApiResponseData<List<KhuyenMaiResponse>> getAllKhuyenMai() {

        return new ApiResponseData<>(khuyenMaiService.getKhuyenMais());
    }

    @GetMapping("/get")
    public ApiResponseData<KhuyenMaiResponse> getKhuyenMaiByIdOrTen(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String tenKhuyenMai
    ) {

        if (id != null) {
            return new ApiResponseData<>(khuyenMaiService.getKhuyenMaiById(id));
        } else if (tenKhuyenMai != null) {
            return new ApiResponseData<>(khuyenMaiService.getKhuyenMaiByTenKhuyenMai(tenKhuyenMai));
        }

        throw (new IllegalArgumentException(ErrorCode.MISSING_PARAMETER.getMessage()));
    }

    @PutMapping("/{id}")
    public void updateKhuyenMai(@RequestBody KhuyenMaiUpdateRequest request, @PathVariable int id) {
        khuyenMaiService.updateKhuyenMai(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteKhuyenMaiById(@PathVariable int id) {
        khuyenMaiService.delete(id);
    }
}
