package com.example.identity.mapper;

import com.example.identity.dto.response.UserResponseDTO;
import com.example.identity.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface UserResponseMapper {

    UserResponseDTO toUserResponseDTO(User user);
}
