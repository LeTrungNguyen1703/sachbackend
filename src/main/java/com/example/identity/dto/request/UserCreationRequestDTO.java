package com.example.identity.dto.request;

import com.example.identity.validator.DobConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Builder
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UserCreationRequestDTO {

    @Size(min = 3, message = "USERNAME_INVALID")
    String userName;

    @NotNull(message = "PASSWORD_NOT_NULL")
    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;

    String firstName;

    String lastName;

    @DobConstraint(min = 18,message = "INVALID_DOB")
    LocalDate dob;

    Set<String> roles;
}