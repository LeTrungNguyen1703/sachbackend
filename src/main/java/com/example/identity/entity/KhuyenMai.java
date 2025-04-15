package com.example.identity.entity;

import com.example.identity.entity.ChiPhiGiaoHang;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "khuyen_mai")
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_khuyen_mai")
    private int id;

    @Column(name = "ten_khuyen_mai", length = 255)
    private String tenKhuyenMai;

    @Column(name = "mieu_ta")
    private String mieuTa;

    @Column(name = "phan_tram_giam")
    private Double phanTramGiam;

    @Column(name = "ngay_bat_dau")
    private Date ngayBatDau;

    @Column(name = "ngay_ket_thuc")
    private Date ngayKetThuc;

    @OneToMany(mappedBy = "khuyenMai", cascade = CascadeType.ALL)
    private List<ChiPhiGiaoHang> danhSachChiPhiGiaoHang;

    // Constructor, getter, setter
}
