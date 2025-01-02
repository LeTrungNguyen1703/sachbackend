package com.example.identity.controller;

import com.example.identity.dto.request.AuthenticationRequest;
import com.example.identity.dto.request.IntrospectRequest;
import com.example.identity.dto.request.LogoutRequest;
import com.example.identity.dto.response.ApiResponseData;
import com.example.identity.dto.response.ApiResponseError;
import com.example.identity.dto.response.AuthenticationResponse;
import com.example.identity.dto.response.IntrospectResponse;
import com.example.identity.exception.ErrorCode;
import com.example.identity.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponseData<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        if (authenticationResponse.isAuthenticated()) {
            return new ApiResponseData<>(authenticationResponse);
        } else {
            return new ApiResponseError(ErrorCode.AUTHENTICATION_FAILED.getCode(), ErrorCode.AUTHENTICATION_FAILED.getMessage());
        }
    }

    @PostMapping("/introspect")
    ApiResponseData<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {

        IntrospectResponse result = authenticationService.introspect(request);

        return new ApiResponseData<>(result);
    }

    @PostMapping("/logout")
    ApiResponseData<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {

        authenticationService.logout(request);
        return new ApiResponseData<>(null);
    }

}
