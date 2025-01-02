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
public class LogoutRequest {

    String token;
}