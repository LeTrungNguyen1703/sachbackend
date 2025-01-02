package com.example.identity.service.Impl;

import com.example.identity.dto.request.PermissionRequest;
import com.example.identity.dto.response.PermissionResponse;
import com.example.identity.entity.Permission;
import com.example.identity.mapper.PermissionMapper;
import com.example.identity.repository.PermissionRepository;
import com.example.identity.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    PermissionMapper permissionMapper;
    PermissionRepository permissionRepository;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        var permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    @Override
    public List<PermissionResponse> getAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream()
                .map(permissionMapper::toPermissionResponse)
                .toList();
    }

    @Override
    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }


}
