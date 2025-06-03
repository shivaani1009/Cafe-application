package com.example.cafe_service.mapper;

import com.example.cafe_service.model.Cafe;
import com.example.cafe_service.dto.CafeDto;


public class CafeMapper {
    public static CafeDto toDto(Cafe cafe){
        CafeDto dto = new CafeDto();
        dto.setId(cafe.getId());
        dto.setName(cafe.getName());
        dto.setLocation(cafe.getLocation());
        dto.setTags(cafe.getTags());
        return dto;
    }

    public static Cafe toEntity(CafeDto dto){
        Cafe cafe = new Cafe();
        cafe.setName(dto.getName());
        cafe.setLocation(dto.getLocation());
        cafe.setTags(dto.getTags());
        return cafe;
    }
}