package com.example.identity.repository;

import com.example.identity.entity.Sach;
import com.example.identity.entity.TheLoai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SachRepository extends JpaRepository<Sach, Integer> {

    Optional<Sach> findByTenSach(String name);

    Page<Sach> findByTenSachContainingIgnoreCase(String tenSach, Pageable pageable);

    @Query("""
                SELECT S FROM Sach S
                JOIN S.danhSachTheLoai TL
                WHERE TL.tenTheLoai IN :danhSachTenTheLoai
                GROUP BY S
                HAVING COUNT(DISTINCT TL.tenTheLoai) >= :soLuongTheLoai
            """)

    Page<Sach> findAllSachByTenTheLoai(@Param("danhSachTenTheLoai") List<String> danhSachTenTheLoai,@Param("soLuongTheLoai") Integer soLuongTheLoai, Pageable pageable);
}
