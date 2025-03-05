package com.example.identity.mapper;

import com.example.identity.dto.request.User.UserCreationRequestDTO;
import com.example.identity.dto.request.User.UserUpdateRequest;
import com.example.identity.dto.response.User.UserResponseDTO;
import com.example.identity.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "danhSachQuyen", ignore = true)
    User toUser(UserCreationRequestDTO request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "danhSachQuyen", ignore = true)
    void updateUser(UserUpdateRequest request, @MappingTarget User user);

    UserResponseDTO toUserResponseDTO(User user);
}
