package com.example.identity.repository;

import com.example.identity.entity.KhuyenMai;
import com.example.identity.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai,Integer> {

    Optional<Object> findByTenKhuyenMai(String tenKhuyenMai);
}
