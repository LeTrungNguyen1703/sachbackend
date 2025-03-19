package com.example.identity.methodsPhoBien;

import com.example.identity.entity.HinhAnh;
import com.example.identity.entity.Sach;
import com.example.identity.entity.User;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.repository.HinhAnhRepository;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class ServiceHelper {
     SachRepository sachRepository;
     UserRepository userRepository;
     HinhAnhRepository hinhAnhRepository;
    public Sach getSachById(Integer id) {
        return sachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.NOT_FOUND));
    }
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.NOT_FOUND));
    }
    public User getUserByUserName(String userName) {
        return userRepository.findByTenDangNhap(userName)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.NOT_FOUND));
    }

    public HinhAnh getHinhAnhById(Integer id) {
        return hinhAnhRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.NOT_FOUND));
    }

    public Pageable getPageable(int pageNo, int pageSize, String sortBy) {
        Pageable pageable;
        if (StringUtils.hasLength(sortBy)) {
            String field = sortBy.split(":")[0];
            String direction = sortBy.split(":")[1];
            Sort.Order order = new Sort.Order(Sort.Direction.fromString(direction), field);
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(order));
        } else {
            pageable = PageRequest.of(pageNo, pageSize);
        }
        return pageable;
    }

}
