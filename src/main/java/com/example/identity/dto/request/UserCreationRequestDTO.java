package com.example.identity.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserCreationRequestDTO {

    String userName;

    String password;

    String firstName;

    String lastName;

    LocalDate dob;
}
