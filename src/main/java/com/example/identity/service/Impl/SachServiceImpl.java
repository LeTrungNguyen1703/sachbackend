package com.example.identity.service.Impl;

import com.example.identity.dto.request.Sach.SachRequest;
import com.example.identity.dto.response.PageResponse;
import com.example.identity.dto.response.Sach.SachResponse;
import com.example.identity.entity.Sach;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.mapper.SachMapper;
import com.example.identity.methodsPhoBien.ServiceHelper;
import com.example.identity.repository.HinhAnhRepository;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.SuDanhGiaRepository;
import com.example.identity.repository.TheLoaiRepository;
import com.example.identity.service.SachService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class SachServiceImpl implements SachService {

    SachRepository sachRepository;
    SachMapper sachMapper;
    TheLoaiRepository theLoaiRepository;
    HinhAnhRepository hinhAnhRepository;
    SuDanhGiaRepository suDanhGiaRepository;
    ServiceHelper serviceHelper;

    @Override
    public SachResponse createSach(SachRequest request) {
        Sach sach = sachMapper.toSach(request);

        if (request.getDanhSachTheLoai() != null) {
            var danhSachTheLoai = theLoaiRepository.findAllByTenTheLoaiIn((request.getDanhSachTheLoai()));
            sach.setDanhSachTheLoai(danhSachTheLoai);
        }

        if (request.getDanhSachHinhAnh() != null) {
            var danhSachAnh = hinhAnhRepository.findAllById(request.getDanhSachHinhAnh());
            sach.setDanhSachHinhAnh(danhSachAnh);
        }

        sachRepository.save(sach);

        return sachMapper.toSachResponse(sach);
    }

    @Override
    public PageResponse<List<SachResponse>> getSachs(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = serviceHelper.getPageable(pageNo, pageSize, sortBy);

        Page<Sach> sachs = sachRepository.findAll(pageable);
        var sachResponse = sachs.stream()
                .map(sachMapper::toSachResponse)
                .toList();

        return PageResponse.<List<SachResponse>>builder()
                .pageNo(sachs.getNumber())
                .pageSize(sachs.getSize())
                .totalPages(sachs.getTotalPages())
                .data(sachResponse)
                .build();
    }

    @Override
    public SachResponse getSachByName(String name) {
        Sach sach = serviceHelper.getSachByTenSach(name);

        return sachMapper.toSachResponse(sach);
    }

    @Override
    public SachResponse getSachById(Integer name) {
        Sach sach = serviceHelper.getSachById(name);
        SachResponse sachResponse = sachMapper.toSachResponse(sach);
        return sachMapper.toSachResponse(sach);
    }


    @Override
    public void updateSach(int id, SachRequest request) {
        Sach sach = serviceHelper.getSachById(id);

        sachMapper.updateSach(request, sach);

        if (!request.getDanhSachTheLoai().isEmpty()) {
            var danhSachTheLoai = theLoaiRepository.findAllByTenTheLoaiIn(request.getDanhSachTheLoai());
            sach.setDanhSachTheLoai(danhSachTheLoai);
        }

        if (!request.getDanhSachHinhAnh().isEmpty()) {
            var danhSachHinhAnh = hinhAnhRepository.findAllById(request.getDanhSachHinhAnh());
            sach.setDanhSachHinhAnh(danhSachHinhAnh);
        }

        sachRepository.save(sach);

    }

    @Override
    public void deleteSach(Integer Id) {
        sachRepository.deleteById(Id);
    }

    @Override
    public void avgDanhGia() {
        var avgRating = suDanhGiaRepository.getAvgRating();
        List<Sach> sachToUpdate = new ArrayList<>();
        avgRating.forEach(suDanhGia -> {
            var sach = serviceHelper.getSachById(suDanhGia.getMaSach());
            sach.setTrungBinhXepHang(suDanhGia.getAvgDiemXepHang());
            sachToUpdate.add(sach);
        });
        sachRepository.saveAll(sachToUpdate);

    }
}
