package com.example.identity.service;

import com.example.identity.dto.request.AuthenticationRequest;
import com.example.identity.dto.request.IntrospectRequest;
import com.example.identity.dto.request.LogoutRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.request.User.UserCreationRequestDTO;
import com.example.identity.dto.request.User.UserUpdateRequest;
import com.example.identity.dto.response.AuthenticationResponse;
import com.example.identity.dto.response.IntrospectResponse;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.dto.response.User.UserResponseDTO;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;
import java.util.List;

public interface TheLoaiService {
    TheLoaiResponse createTheLoai(TheLoaiRequest request);
    PageResponse<List<TheLoaiResponse>> getTheLoais(int pageNo, int pageSize, String sortBy);
    TheLoaiResponse getTheLoaiById(String id);
    TheLoaiResponse updateTheLoai(String Id, TheLoaiUpdateRequest request);
}
