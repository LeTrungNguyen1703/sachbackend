package com.example.identity.repository;

import com.example.identity.entity.SuDanhGia;
import com.example.identity.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuDanhGiaRepository extends JpaRepository<SuDanhGia,Long> {

}
