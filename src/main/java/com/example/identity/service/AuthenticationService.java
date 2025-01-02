package com.example.identity.service;

import com.example.identity.dto.request.AuthenticationRequest;
import com.example.identity.dto.request.IntrospectRequest;
import com.example.identity.dto.request.LogoutRequest;
import com.example.identity.dto.response.AuthenticationResponse;
import com.example.identity.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
    void logout(LogoutRequest request) throws ParseException, JOSEException;
}
