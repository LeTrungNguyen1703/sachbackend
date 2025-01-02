package com.example.identity.service;

import com.example.identity.dto.request.UserCreationRequestDTO;
import com.example.identity.dto.request.UserUpdateRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserCreationRequestDTO request);
    PageResponse<List<UserResponseDTO>> getUsers(int pageNo, int pageSize, String sortBy);
    UserResponseDTO getUserResponseById(String id);
    UserResponseDTO getMyInforByToken();
    UserResponseDTO updateUser(String userId, UserUpdateRequest request);
}
