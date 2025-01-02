package com.example.identity.service;

import com.example.identity.dto.request.PermissionRequest;
import com.example.identity.dto.response.PermissionResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PermissionService {

    PermissionResponse create(PermissionRequest request);

    List<PermissionResponse> getAll();

    void delete(String permission);
}
