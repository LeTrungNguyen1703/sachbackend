package com.example.identity.service;

import com.example.identity.dto.request.User.UserCreationRequestDTO;
import com.example.identity.dto.request.User.UserUpdateRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.User.UserResponseDTO;

import java.util.List;

public interface UserService {

    UserResponseDTO createUser(UserCreationRequestDTO request);
    PageResponse<List<UserResponseDTO>> getUsers(int pageNo, int pageSize, String sortBy);
    UserResponseDTO getUserResponseById(Integer id);
    UserResponseDTO getMyInforByToken();
    UserResponseDTO updateUser(Integer userId, UserUpdateRequest request);
}
