package com.example.identity.mapper;

import com.example.identity.dto.request.UserCreationRequestDTO;
import com.example.identity.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequestDTO request);
}
