package com.example.identity.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationRequest {
    private String username;
    private String password;

}
