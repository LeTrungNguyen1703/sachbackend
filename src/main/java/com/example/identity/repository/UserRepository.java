package com.example.identity.repository;

import com.example.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByTenDangNhap(String userName);

    Optional<User> findByTenDangNhap(String userName);
}
