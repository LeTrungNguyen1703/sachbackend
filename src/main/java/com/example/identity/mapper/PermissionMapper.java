package com.example.identity.mapper;

import com.example.identity.dto.request.PermissionRequest;
import com.example.identity.dto.request.UserCreationRequestDTO;
import com.example.identity.dto.response.PermissionResponse;
import com.example.identity.dto.response.UserResponseDTO;
import com.example.identity.entity.Permission;
import com.example.identity.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
