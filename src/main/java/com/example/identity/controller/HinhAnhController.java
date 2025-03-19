package com.example.identity.controller;

import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.HinhAnh.HinhAnhResponse;
import com.example.identity.exception.ErrorCode;
import com.example.identity.service.HinhAnhService;
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

    @GetMapping("/get/{id}")
    public ApiResponseData<HinhAnhResponse> getHinhAnhById(
            @PathVariable Integer id
    ) {
        if (id != null) {
            return new ApiResponseData<>(hinhAnhService.getHinhAnhById(id));
        } 
        throw (new IllegalArgumentException(ErrorCode.MISSING_PARAMETER.getMessage()));
    }

    @PutMapping("/{id}")
    public ApiResponseData<String> updateHinhAnh(@PathVariable Integer id,@RequestParam(required = false) Integer idSach,@RequestParam("file") MultipartFile file) throws IOException {
        hinhAnhService.updateHinhAnh(id,idSach, file);
        return new ApiResponseData<>();
    }

    @DeleteMapping("/{id}")
    public ApiResponseData<String> deleteHinhAnhById(@PathVariable int id) {
        hinhAnhService.delete(id);
        return new ApiResponseData<>();
    }

}
