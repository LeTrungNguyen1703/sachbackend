package com.example.identity.mapper;

import com.example.identity.dto.request.Sach.SachRequest;
import com.example.identity.dto.request.SuDanhGia.SuDanhGiaRequest;
import com.example.identity.dto.response.Sach.SachResponse;
import com.example.identity.dto.response.SuDanhGia.SuDanhGiaResponse;
import com.example.identity.entity.Sach;
import com.example.identity.entity.SuDanhGia;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SachMapper {

    @Mapping(target = "sach", ignore = true)
    @Mapping(target = "user", ignore = true)
    Sach toSach(SachRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "sach", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateSach(SachRequest request, @MappingTarget Sach object);

//    @Mapping(target = "sach", ignore = true)
//    @Mapping(target = "user", ignore = true)
    SachResponse toSachResponse(Sach response);
}
