package com.example.cafe_service.controller;
import com.example.cafe_service.repository.CafeRepository;
import com.example.cafe_service.dto.CafeDto;
import com.example.cafe_service.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cafes")
public class CafeController{
    @Autowired
    private CafeRepository cafeRepository;
    @Autowired
    private CafeService cafeService;
    // Get all cafes
    @GetMapping
    public List<CafeDto> getAllCafes() {
        return cafeService.getAllCafes();
    }

    // Get a single cafe by ID
    @GetMapping("/{id}")
    public CafeDto getCafeById(@PathVariable Integer id) {
        return cafeService.getCafeById(id);
    }

    // Get cafes by location
    @GetMapping(params = "location")
    public List<CafeDto> getCafesByLocation(@RequestParam String location) {
        return cafeService.getCafesByLocation(location);
    }
    
    @GetMapping("/nearby") 
    public List<CafeDto> getNearbyCafes(@RequestParam("lat") Double userLat, @RequestParam("long") Double userLong){
        return cafeService.getNearbyCafes(userLat, userLong);
    }

    // Add a new cafe
    @PostMapping
    public CafeDto addCafe(@RequestBody CafeDto cafeDto) {
        return cafeService.addCafe(cafeDto);
    }

    // Delete a cafe
    @DeleteMapping("/{id}")
    public void deleteCafe(@PathVariable Integer id) {
        cafeService.deleteCafe(id);
    }

}