package com.example.identity.service.Impl;

import com.example.identity.dto.request.UserCreationRequestDTO;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.UserResponseDTO;
import com.example.identity.entity.User;
import com.example.identity.mapper.UserMapper;
import com.example.identity.mapper.UserResponseMapper;
import com.example.identity.repository.UserRepository;
import com.example.identity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public User createUser(UserCreationRequestDTO request) {
        User user = userMapper.toUser(request);
        userRepository.save(user);
        log.info("Creating user: {}", user.getId());
        return user;
    }

    @Override
    public PageResponse<List<UserResponseDTO>> getUsers(int pageNo, int pageSize, String sortBy) {
        Pageable pageable;
        if (StringUtils.hasLength(sortBy)) {
            String field = sortBy.split(":")[0];
            String direction = sortBy.split(":")[1];
            Sort.Order order = new Sort.Order(Sort.Direction.fromString(direction), field);
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(order));
        } else {
            pageable = PageRequest.of(pageNo, pageSize);
        }
        Page<User> users = userRepository.findAll(pageable);
        List<UserResponseDTO> userResponseDTOS = users.stream()
                .map(userResponseMapper::toUserResponseDTO)
                .toList();

        return PageResponse.<List<UserResponseDTO>>builder()
                .pageNo(users.getNumber())
                .pageSize(users.getSize())
                .totalPages(users.getTotalPages())
                .data(userResponseDTOS)
                .build();
    }
}
