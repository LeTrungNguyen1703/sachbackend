package com.example.identity.service;

import com.example.identity.dto.request.UserCreationRequestDTO;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.UserResponseDTO;
import com.example.identity.entity.User;

import java.util.List;

public interface UserService {

    User createUser(UserCreationRequestDTO request);
    PageResponse<List<UserResponseDTO>> getUsers(int pageNo, int pageSize, String sortBy);
}
