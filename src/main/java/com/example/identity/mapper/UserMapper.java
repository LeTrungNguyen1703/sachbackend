package com.example.identity.mapper;

import com.example.identity.dto.request.UserCreationRequestDTO;
import com.example.identity.dto.request.UserUpdateRequest;
import com.example.identity.dto.response.UserResponseDTO;
import com.example.identity.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", ignore = true)
    User toUser(UserCreationRequestDTO request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", ignore = true)
    void updateUser(UserUpdateRequest request, @MappingTarget User user);

    UserResponseDTO toUserResponseDTO(User user);
}
