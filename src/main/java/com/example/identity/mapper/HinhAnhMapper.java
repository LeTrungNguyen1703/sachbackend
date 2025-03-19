package com.example.identity.mapper;

import com.example.identity.dto.request.HInhAnh.HinhAnhRequest;
import com.example.identity.dto.request.HInhAnh.HinhAnhUpdateRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.response.HinhAnh.HinhAnhResponse;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.entity.HinhAnh;
import com.example.identity.entity.TheLoai;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface HinhAnhMapper {

    @Mapping(target = "sach", ignore = true)
    @Mapping(target = "duLieuAnh", ignore = true)
    HinhAnh toHinhAnh(HinhAnhRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "sach", ignore = true)
    @Mapping(target = "duLieuAnh", ignore = true)
    void updateHinhAnh(HinhAnhUpdateRequest request, @MappingTarget HinhAnh hinhAnh);

    @Mapping(target = "duLieuAnh", ignore = true)
    HinhAnhResponse toHinhAnhResponse(HinhAnh response);
}
