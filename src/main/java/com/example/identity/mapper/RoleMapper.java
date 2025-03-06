package com.example.identity.mapper;

import com.example.identity.dto.request.PermissionRequest;
import com.example.identity.dto.request.RoleRequest;
import com.example.identity.dto.request.User.UserUpdateRequest;
import com.example.identity.dto.response.PermissionResponse;
import com.example.identity.dto.response.RoleResponse;
import com.example.identity.entity.Permission;
import com.example.identity.entity.Role;
import com.example.identity.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "permissions", ignore = true)
    void updateRole(RoleRequest request, @MappingTarget Role role);
}
