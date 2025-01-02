package com.example.identity.dto.response;

import com.example.identity.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponseDTO {

    String userName;

    String firstName;

    String lastName;

    LocalDate dob;

    Set<RoleResponse> roles;
}
