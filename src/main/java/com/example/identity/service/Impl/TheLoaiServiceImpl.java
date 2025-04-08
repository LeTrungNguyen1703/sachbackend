package com.example.identity.service.Impl;

import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.entity.TheLoai;
import com.example.identity.exception.ErrorCode;
import com.example.identity.exception.ResourceAlreadyExitsException;
import com.example.identity.exception.ResourceNotFoundException;
import com.example.identity.mapper.TheLoaiMapper;
import com.example.identity.repository.SachRepository;
import com.example.identity.repository.TheLoaiRepository;
import com.example.identity.service.TheLoaiService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class TheLoaiServiceImpl implements TheLoaiService {

    TheLoaiRepository theLoaiRepository;
    TheLoaiMapper theLoaiMapper;
    SachRepository sachRepository;

    @Override
    public TheLoaiResponse createTheLoai(TheLoaiRequest request) {
        TheLoai theLoai = theLoaiMapper.toTheLoai(request);
        if (theLoaiRepository.findByTenTheLoai(request.getTenTheLoai()).isPresent()){
            throw (new ResourceAlreadyExitsException(ErrorCode.THE_LOAI_ALREADY_EXITS));
        }

        theLoaiRepository.save(theLoai);

        return theLoaiMapper.toTheLoaiResponse(theLoai);
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public List<TheLoaiResponse> getTheLoais() {
        List<TheLoai> theLoai = theLoaiRepository.findAll();

        return theLoai.stream()
                .map(theLoaiMapper::toTheLoaiResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TheLoaiResponse getTheLoaiById(int id) {
        TheLoai theLoai = theLoaiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.THE_LOAI_NOT_FOUND));

        return theLoaiMapper.toTheLoaiResponse(theLoai);
    }

    @Override
    public TheLoaiResponse getTheLoaiByTenTheLoai(String tenTheLoai) {

        TheLoai theLoai = theLoaiRepository.findByTenTheLoai((tenTheLoai))
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.THE_LOAI_NOT_FOUND));

        return theLoaiMapper.toTheLoaiResponse(theLoai);
    }

    @Override
    public TheLoaiResponse updateTheLoai(int Id, TheLoaiUpdateRequest request) {
        TheLoai theLoai = theLoaiRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorCode.THE_LOAI_NOT_FOUND));

        theLoaiMapper.updateTheLoai(request,theLoai);

        theLoaiRepository.save(theLoai);
        return theLoaiMapper.toTheLoaiResponse(theLoai);
    }

    @Override
    public void delete(int id) {
        theLoaiRepository.deleteById(id);
    }



}
