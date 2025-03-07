package com.example.identity.methodsPhoBien;

import com.example.identity.entity.Sach;
import com.example.identity.entity.User;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class ServiceHelper {
     SachRepository sachRepository;
     UserRepository userRepository;

    public Sach getSachById(Integer id) {
        return sachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.SACH_NOT_FOUND));
    }
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.USER_NOT_FOUND));
    }

}
