package com.example.identity.mapper;

import com.example.identity.dto.request.KhuyenMai.KhuyenMaiRequest;
import com.example.identity.dto.request.KhuyenMai.KhuyenMaiUpdateRequest;
import com.example.identity.dto.response.KhuyenMai.KhuyenMaiResponse;
import com.example.identity.entity.KhuyenMai;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface KhuyenMaiMapper {

    KhuyenMai toKhuyenMai(KhuyenMaiRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateKhuyenMai(KhuyenMaiUpdateRequest request, @MappingTarget KhuyenMai khuyenMai);

    KhuyenMaiResponse toKhuyenMaiResponse(KhuyenMai response);
}