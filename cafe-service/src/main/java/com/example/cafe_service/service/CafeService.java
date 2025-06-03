package com.example.cafe_service.service;

import com.example.cafe_service.dto.CafeDto;
import com.example.cafe_service.mapper.CafeMapper;
import com.example.cafe_service.model.Cafe;
import com.example.cafe_service.repository.CafeRepository;
import com.example.cafe_service.exception.CafeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CafeService {
    @Autowired
    private CafeRepository CafeRepository;

    public List<CafeDto> getAllCafes(){
        List<Cafe> cafes = CafeRepository.findAll();
        return cafes.stream()
                            .map(CafeMapper::toDto)
                            .collect(Collectors.toList());
    }

    public CafeDto getCafeById(Integer id) {
        Cafe cafe = CafeRepository.findById(id)
                        .orElseThrow(() -> new CafeNotFoundException("Cafe not found with id: " + id));
        return CafeMapper.toDto(cafe);
    }

    public CafeDto addCafe(CafeDto cafeDto) {
        Cafe cafe = CafeMapper.toEntity(cafeDto);
        Cafe savedCafe = CafeRepository.save(cafe);
        return CafeMapper.toDto(savedCafe);
    }

    public void deleteCafe(Integer id) {
        CafeRepository.deleteById(id);
    }

    public List<CafeDto> getCafesByLocation(String location) {
        List<Cafe> cafes = CafeRepository.findByLocationOrderByNameAsc(location);
        return cafes.stream()
                    .map(CafeMapper::toDto)
                    .collect(Collectors.toList());
    }
}