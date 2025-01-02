package com.example.identity.service.Impl;

import com.example.identity.dto.request.AuthenticationRequest;
import com.example.identity.dto.request.IntrospectRequest;
import com.example.identity.dto.request.LogoutRequest;
import com.example.identity.dto.response.AuthenticationResponse;
import com.example.identity.dto.response.IntrospectResponse;
import com.example.identity.entity.InvalidatedToken;
import com.example.identity.entity.Permission;
import com.example.identity.entity.Role;
import com.example.identity.entity.User;
import com.example.identity.exception.AppException;
import com.example.identity.exception.AuthenticatedException;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.repository.InvalidatedTokenRepository;
import com.example.identity.repository.UserRepository;
import com.example.identity.service.AuthenticationService;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    UserRepository userRepository;
    InvalidatedTokenRepository invalidatedTokenRepository;
    PasswordEncoder passwordEncoder;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SECRET_KEY;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user = userRepository.findByUserName(request.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));

        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!authenticated) throw new AuthenticatedException(ErrorCode.PASSWORD_NOT_MATCH);

        String token = this.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .build();
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        String token = request.getToken();

        boolean isValidToken = true;

        try {
            this.verifyToken(token);
        } catch (AppException e) {
            isValidToken = false;
        }

        return IntrospectResponse.builder()
                .valid(isValidToken)
                .build();
    }

    private SignedJWT verifyToken(String token) throws JOSEException, ParseException {

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        JWSVerifier verifier = new MACVerifier(SECRET_KEY.getBytes());

        boolean verified = signedJWT.verify(verifier);

        if (!(verified && expiryTime.after(new Date()))) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        if (invalidatedTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID())) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }

        return signedJWT;
    }

    @Override
    public void logout(LogoutRequest request) throws ParseException, JOSEException {
        SignedJWT signedJWT = this.verifyToken(request.getToken());

        String jwtId = signedJWT.getJWTClaimsSet().getJWTID();
        Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        InvalidatedToken invalidatedToken = InvalidatedToken.builder()
                .id(jwtId)
                .expiryTime(expiryTime)
                .build();

        invalidatedTokenRepository.save(invalidatedToken);
    }

    private String generateToken(User user) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUserName())
                .issuer("devteria.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", buildScope(user))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SECRET_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Failed to sign token {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private String buildScope(User user) {
        return user.getRoles().stream()
                .flatMap(role -> Stream.concat(
                        Stream.of("ROLE_" + role.getName()),
                        role.getPermissions().stream().map(Permission::getName)
                ))
                .collect(Collectors.joining(" "));
    }

}
