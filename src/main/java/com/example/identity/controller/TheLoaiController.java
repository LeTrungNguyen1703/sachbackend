package com.example.identity.controller;

import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.User.UserCreationRequestDTO;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.dto.response.User.UserResponseDTO;
import com.example.identity.exception.ErrorCode;
import com.example.identity.service.TheLoaiService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/the-loai")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TheLoaiController {
    TheLoaiService theLoaiService;

    @PostMapping
    public ApiResponseData<TheLoaiResponse> createTheLoai(@RequestBody @Valid TheLoaiRequest request) {

        return new ApiResponseData<>(theLoaiService.createTheLoai(request));
    }

    @GetMapping
    public ApiResponseData<List<TheLoaiResponse>> getAllTheLoai() {

        return new ApiResponseData<>(theLoaiService.getTheLoais());
    }

    @GetMapping("/get")
    public ApiResponseData<TheLoaiResponse> getTheLoaiByIdOrTen(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String tenTheLoai
    ) {

        if (id != null) {
            return new ApiResponseData<>(theLoaiService.getTheLoaiById(id));
        }
        else if (tenTheLoai != null) {
            return new ApiResponseData<>(theLoaiService.getTheLoaiByTenTheLoai(tenTheLoai));
        }

        throw (new IllegalArgumentException(ErrorCode.MISSING_PARAMETER.getMessage()));
    }

    @DeleteMapping("/{id}")
    public void deleteTheLoaiById(@PathVariable int id) {
        theLoaiService.delete(id);

    }
}
