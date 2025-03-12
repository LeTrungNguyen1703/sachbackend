package com.example.identity.controller;

import com.example.identity.dto.request.User.UserCreationRequestDTO;
import com.example.identity.dto.request.User.UserUpdateRequest;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.User.UserResponseDTO;
import com.example.identity.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping
    public ApiResponseData<UserResponseDTO> creatUser(@RequestBody @Valid UserCreationRequestDTO request) {

        return new ApiResponseData<>(userService.createUser(request));
    }

    @GetMapping
    public ApiResponseData<PageResponse<List<UserResponseDTO>>> getUsers(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String sortBy
    ) {
        return new ApiResponseData<>(userService.getUsers(pageNo, pageSize, sortBy));
    }

    @GetMapping("/{id}")
    public ApiResponseData<UserResponseDTO> getUserById(@PathVariable Integer id, @RequestHeader("Authorization") String token) {
        return new ApiResponseData<>(userService.getUserResponseById(id));
    }

    @GetMapping("/my-info")
    public ApiResponseData<UserResponseDTO> getMyInfo() {
        return new ApiResponseData<>(userService.getMyInforByToken());
    }

    @PutMapping
    ApiResponseData<UserResponseDTO> updateUser(@RequestBody UserUpdateRequest request) {
        return new ApiResponseData<>(userService.updateUser(request));
    }

}
