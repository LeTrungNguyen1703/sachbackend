package com.example.identity.controller;

import com.example.identity.dto.request.PermissionRequest;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.PermissionResponse;
import com.example.identity.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionController {
    PermissionService permissionService;

    @PostMapping
    ApiResponseData<PermissionResponse> create(@RequestBody PermissionRequest request) {

        return new ApiResponseData<>(permissionService.create(request));
    }

    @GetMapping
    ApiResponseData<List<PermissionResponse>> getAll() {

        return new ApiResponseData<>(permissionService.getAll());
    }

    @DeleteMapping
    ApiResponseData<?> delete(@RequestParam String id) {
        permissionService.delete(id);
        return new ApiResponseData<>("Permission deleted success");
    }
}
