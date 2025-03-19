package com.example.identity.repository;

import com.example.identity.entity.Sach;
import com.example.identity.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SachRepository extends JpaRepository<Sach,Integer> {

    Optional<Sach> findByTenSach(String name);
}
