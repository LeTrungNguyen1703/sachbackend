package com.example.identity.service.Impl;

import com.example.identity.dto.request.SuDanhGia.SuDanhGiaRequest;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaProjection;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaResponse;
import com.example.identity.entity.Sach;
import com.example.identity.entity.SuDanhGia;
import com.example.identity.entity.User;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.mapper.SuDanhGiaMapper;
import com.example.identity.methodsPhoBien.ServiceHelper;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.SuDanhGiaRepository;
import com.example.identity.repository.UserRepository;
import com.example.identity.service.SuDanhGiaService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class SuDanhGiaServiceImpl implements SuDanhGiaService {

    SuDanhGiaRepository suDanhGiaRepository;
    SuDanhGiaMapper suDanhGiaMapper;
    SachRepository sachRepository;
    UserRepository userRepository;
    ServiceHelper serviceHelper;

    @Override
    public SuDanhGiaResponse createSuDanhGia(SuDanhGiaRequest request) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        SuDanhGia suDanhGia = suDanhGiaMapper.toSuDanhGia(request);

        User user = serviceHelper.getUserByUserName(userName);
        Sach sach = serviceHelper.getSachById(request.getSach());

        suDanhGia.setSach(sach);
        suDanhGia.setUser(user);

        suDanhGiaRepository.save(suDanhGia);

        return suDanhGiaMapper.toSachDanhGiaResponse(suDanhGia);
    }

    @Override
    public List<SuDanhGiaResponse> getSuDanhGias() {
        var listDanhGia = suDanhGiaRepository.findAll();
        return listDanhGia
                .stream()
                .map(suDanhGiaMapper::toSachDanhGiaResponse)
                .toList();
    }

    @Override
    public SuDanhGiaResponse getSuDanhGiaById(long id) {
        var danhGia = this.localGetSuDanhGiaById(id);
        return suDanhGiaMapper.toSachDanhGiaResponse(danhGia);
    }

    @Override
    public void updateSuDanhGia(long id, SuDanhGiaRequest request) {

        SuDanhGia suDanhGia = this.localGetSuDanhGiaById(id);
        suDanhGiaMapper.updateSuDanhGia(request, suDanhGia);

        suDanhGiaRepository.save(suDanhGia);

    }

    @Override
    public void delete(long id) {
        suDanhGiaRepository.deleteById(id);
    }

    @Override
    public void avgDanhGia() {
        var avgRating= suDanhGiaRepository.getAvgRating();

        avgRating.forEach(suDanhGia -> {
            var sach = serviceHelper.getSachById(suDanhGia.getMaSach());
            sach.setTrungBinhXepHang(suDanhGia.getAvgDiemXepHang());

            sachRepository.save(sach);
        });
    }

    private SuDanhGia localGetSuDanhGiaById(long id) {
        return suDanhGiaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.NOT_FOUND));
    }


}
