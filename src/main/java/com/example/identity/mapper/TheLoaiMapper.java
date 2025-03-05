package com.example.identity.mapper;

import com.example.identity.dto.request.TheLoai.TheLoaiRequest;
import com.example.identity.dto.request.TheLoai.TheLoaiUpdateRequest;
import com.example.identity.dto.request.User.UserCreationRequestDTO;
import com.example.identity.dto.request.User.UserUpdateRequest;
import com.example.identity.dto.response.TheLoai.TheLoaiResponse;
import com.example.identity.dto.response.User.UserResponseDTO;
import com.example.identity.entity.TheLoai;
import com.example.identity.entity.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TheLoaiMapper {

    @Mapping(target = "danhSachQuyenSach", ignore = true)
    TheLoai toTheLoai(TheLoaiRequest request);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "danhSachQuyenSach", ignore = true)
    void updateTheLoai(TheLoaiUpdateRequest request, @MappingTarget TheLoai theLoai);

    TheLoaiResponse toTheLoaiResponse(TheLoai response);
}
