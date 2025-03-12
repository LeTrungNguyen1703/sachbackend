package com.example.identity.repository;

import com.example.identity.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TheLoaiRepository extends JpaRepository<TheLoai,Integer> {

    Optional<TheLoai> findByTenTheLoai(String tenTheLoai);

    List<TheLoai> findAllByTenTheLoaiIn(List<String> tenTheLoai);
}
