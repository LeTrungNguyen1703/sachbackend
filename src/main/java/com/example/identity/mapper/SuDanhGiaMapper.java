package com.example.identity.mapper;

import com.example.identity.dto.request.SuDanhGia.SuDanhGiaRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.entity.SuDanhGia;
import com.example.identity.entity.TheLoai;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SuDanhGiaMapper {

    @Mapping(target = "sach", ignore = true)
    @Mapping(target = "user", ignore = true)
    SuDanhGia toSuDanhGia(SuDanhGiaRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "sach", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateSuDanhGia(SuDanhGiaRequest request, @MappingTarget SuDanhGia object);

//    @Mapping(target = "sach", ignore = true)
//    @Mapping(target = "user", ignore = true)
    SuDanhGiaResponse toSachDanhGiaResponse(SuDanhGia response);
}
