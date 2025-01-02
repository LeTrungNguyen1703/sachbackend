package com.example.identity.service;

import com.example.identity.dto.request.RoleRequest;
import com.example.identity.dto.request.UserCreationRequestDTO;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.RoleResponse;
import com.example.identity.dto.response.UserResponseDTO;

import java.util.List;

public interface RoleService {

    RoleResponse create(RoleRequest request);

    List<RoleResponse> getAll();

    void delete(String role);

}
