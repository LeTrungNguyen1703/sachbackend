package com.example.identity.entity;

import com.example.identity.entity.DonHang;
import com.example.identity.entity.HinhThucGiaoHang;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chi_phi_giao_hang")
public class ChiPhiGiaoHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_chi_phi_giao_hang")
    private int id;

    @Column(name = "gia_ap_dung")
    private double giaApDung;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_hinh_thuc_giao_hang")
    private HinhThucGiaoHang hinhThucGiaoHang;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinColumn(name = "ma_khuyen_mai", nullable = true)
    private KhuyenMai khuyenMai;

    @OneToMany(mappedBy = "chiPhiGiaoHangApDung", cascade = CascadeType.ALL)
    private List<DonHang> danhSachDonHang;
}
