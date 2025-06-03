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

    public List<CafeDto> getNearbyCafes(Double userLat, Double userLong){
        List<Cafe> allcafes = CafeRepository.findAll();
        return allcafes.stream()
                        .filter(cafe -> {
                            Double cafeLat = cafe.getLatitude();
                            Double cafeLong = cafe.getLongitude();
                            Double distance = calculateDistance(userLat, userLong, cafeLat, cafeLong);
                            return distance<3.0;
                        })
                        .map(CafeMapper::toDto)
                        .collect(Collectors.toList());
    }


    private Double calculateDistance(Double userLat, Double userLong, Double cafeLat, Double cafeLong){
        //Haversine formula
        final int EARTH_RADIUS = 6371; // km
        Double latDistance = Math.toRadians(cafeLat - userLat);
        Double longDistance = Math.toRadians(cafeLong - userLong);
         double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(cafeLat))
            * Math.sin(longDistance / 2) * Math.sin(longDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}

