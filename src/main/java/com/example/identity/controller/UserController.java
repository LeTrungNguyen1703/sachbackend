package com.example.identity.controller;

import com.example.identity.dto.request.UserCreationRequestDTO;
import com.example.identity.dto.response.ResponseData;
import com.example.identity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseData<?> creatUser(@RequestBody UserCreationRequestDTO request) {

        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User created successfully", userService.createUser(request));
    }

    @GetMapping
    public ResponseData<?> getUsers(
            @RequestParam int pageNo,
            @RequestParam int pageSize,
            @RequestParam(required = false) String sortBy
    ) {
        return new ResponseData<>(HttpStatus.OK.value(), "Users fetched successfully", userService.getUsers(pageNo, pageSize, sortBy));
    }
}
