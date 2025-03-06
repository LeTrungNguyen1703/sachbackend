package com.example.identity.service.Impl;

import com.example.identity.dto.request.PermissionRequest;
import com.example.identity.dto.request.RoleRequest;
import com.example.identity.dto.response.PermissionResponse;
import com.example.identity.dto.response.RoleResponse;
import com.example.identity.entity.Permission;
import com.example.identity.entity.Role;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.mapper.PermissionMapper;
import com.example.identity.mapper.RoleMapper;
import com.example.identity.repository.PermissionRepository;
import com.example.identity.repository.RoleRepository;
import com.example.identity.service.PermissionService;
import com.example.identity.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class RoleServiceImpl implements RoleService {

    RoleMapper roleMapper;
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;

    @Override
    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionRepository.findAllById(request.getPermissions());

        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }

    @Override
    public void delete(String role) {
        roleRepository.deleteById(role);
    }

    @Override
    public void update(RoleRequest request, String id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.ROLE_NOT_FOUND));

        roleMapper.updateRole(request,role);

        roleRepository.save(role);
    }
}
