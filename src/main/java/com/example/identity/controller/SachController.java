package com.example.identity.controller;

import com.example.identity.dto.request.Sach.SachRequest;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.Sach.SachResponse;
import com.example.identity.service.SachService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sach")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SachController {

    SachService sachService;
    @PostMapping
    public ApiResponseData<SachResponse> createSach(@RequestBody @Valid SachRequest request) {

        return new ApiResponseData<>(sachService.createSach(request));
    }

    @GetMapping
    public ApiResponseData<PageResponse<List<SachResponse>>> getSachs(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String sortBy
    ) {
        return new ApiResponseData<>(sachService.getSachs(pageNo, pageSize, sortBy));
    }

    @GetMapping("/{id}")
    public ApiResponseData<SachResponse> getSachById(@PathVariable Integer id) {
        return new ApiResponseData<>(sachService.getSachById(id));
    }

    @GetMapping("/get-by-name")
    public ApiResponseData<SachResponse> getSachByName(@RequestParam String name) {
        return new ApiResponseData<>(sachService.getSachByName(name));
    }

    @PutMapping("/{id}")
    ApiResponseData<String> updateSach(@PathVariable int id,@RequestBody SachRequest request) {
        sachService.updateSach(id, request);
        return new ApiResponseData<>("Cap nhat thanh cong");
    }

    @DeleteMapping("/{id}")
    ApiResponseData<String> deleteSachById (@PathVariable Integer id){
        sachService.deleteSach(id);
        return new ApiResponseData<>("Xoa thanh cong");
    }

    @PostMapping("/avgRating")
    public ApiResponseData<String> getAVGRating() {
        sachService.avgDanhGia();
        return new ApiResponseData<>("Cap nhat trung binh danh gia thanh cong");
    }

    @PatchMapping("/{idSach}")
    public void chooseHinhAnhIcon(@PathVariable Integer idSach, @RequestParam Integer idImg) {
        sachService.chooseIcon(idImg, idSach);
    }

}
