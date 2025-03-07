package com.example.identity.controller;

import com.example.identity.dto.request.PermissionRequest;
import com.example.identity.dto.request.RoleRequest;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.PermissionResponse;
import com.example.identity.dto.response.RoleResponse;
import com.example.identity.service.PermissionService;
import com.example.identity.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponseData<RoleResponse> create(@RequestBody RoleRequest request) {

        return new ApiResponseData<>(roleService.create(request));
    }

    @GetMapping
    ApiResponseData<List<RoleResponse>> getAll() {

        return new ApiResponseData<>(roleService.getAll());
    }

    @PutMapping
    ApiResponseData<RoleResponse> updateRole(
            @RequestBody RoleRequest request,
            String id
            ) {
        return new ApiResponseData<>(roleService.update(request,id));

    }

    @DeleteMapping
    ApiResponseData<?> delete(@RequestParam String id) {
        roleService.delete(id);
        return new ApiResponseData<>("Role deleted success");
    }
}
