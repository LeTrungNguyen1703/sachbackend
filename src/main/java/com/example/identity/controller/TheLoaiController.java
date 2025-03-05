package com.example.identity.controller;

import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.User.UserCreationRequestDTO;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.dto.response.User.UserResponseDTO;
import com.example.identity.service.TheLoaiService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
