package com.example.identity.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Getter
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserResponseDTO {

    String id;

    String userName;

    String firstName;

    String lastName;

    LocalDate dob;
}
