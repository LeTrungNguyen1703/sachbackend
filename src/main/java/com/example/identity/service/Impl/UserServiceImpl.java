package com.example.identity.service.Impl;

import com.example.identity.dto.request.User.UserCreationRequestDTO;
import com.example.identity.dto.request.User.UserUpdateRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.User.UserResponseDTO;
import com.example.identity.entity.User;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceAlreadyExitsException;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.mapper.UserMapper;
import com.example.identity.repository.RoleRepository;
import com.example.identity.repository.UserRepository;
import com.example.identity.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;


    @Override
    public UserResponseDTO createUser(UserCreationRequestDTO request) {
        if (userRepository.existsByTenDangNhap(request.getTenDangNhap())) {
            throw new ResourceAlreadyExitsException(ErrorCode.USER_ALREADY_EXISTS);
        }
        User user = userMapper.toUser(request);
        user.setMatKhau(passwordEncoder.encode(request.getMatKhau()));

        var roles = roleRepository.findAllById(request.getDanhSachQuyen());


        user.setDanhSachQuyen(new ArrayList<>(roles));
        user = userRepository.save(user);
        log.info("Creating user: {}", user.getMaNguoiDung());

        return userMapper.toUserResponseDTO(user);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public PageResponse<List<UserResponseDTO>> getUsers(int pageNo, int pageSize, String sortBy) {
        //Authorization
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("User: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

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
                .map(userMapper::toUserResponseDTO)
                .toList();

        return PageResponse.<List<UserResponseDTO>>builder()
                .pageNo(users.getNumber())
                .pageSize(users.getSize())
                .totalPages(users.getTotalPages())
                .data(userResponseDTOS)
                .build();
    }

    @Override
    @PostAuthorize("returnObject.tenDangNhap == authentication.name")
    public UserResponseDTO getUserResponseById(Integer id) {
        User user = getUserById(id);
        return userMapper.toUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO getMyInforByToken() {
        var context = SecurityContextHolder.getContext().getAuthentication();
        String name = context.getName();
        User user = this.getUserByUsername(name);

        return userMapper.toUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(Integer userId, UserUpdateRequest request) {
        User user = this.getUserById(userId);

       userMapper.updateUser(request, user);

       if (request.getMatKhau() != null) {
           user.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
       }

       var roles = roleRepository.findAllById(request.getDanhSachQuyen());

       user.setDanhSachQuyen(new ArrayList<>(roles));

       user = userRepository.save(user);

       return userMapper.toUserResponseDTO(user);
    }


    private User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));
    }

    private User getUserByUsername(String username) {
        return userRepository.findByTenDangNhap(username)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));
    }

}
