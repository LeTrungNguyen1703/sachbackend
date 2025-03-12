package com.example.identity.repository;

import com.example.identity.dto.response.SuDanhGia.SuDanhGiaProjection;
import com.example.identity.entity.SuDanhGia;
import com.example.identity.entity.TheLoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuDanhGiaRepository extends JpaRepository<SuDanhGia,Long> {

    @Query("SELECT S.sach.maSach AS maSach,AVG(S.diemXepHang) AS avgDiemXepHang " +
            "FROM SuDanhGia S " +
            "GROUP BY S.sach.maSach")
    List<SuDanhGiaProjection> getAvgRating();
}
