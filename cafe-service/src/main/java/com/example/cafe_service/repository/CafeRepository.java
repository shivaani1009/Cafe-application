package com.example.cafe_service.repository;

import com.example.cafe_service.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CafeRepository extends JpaRepository<Cafe, Integer>{
    List<Cafe> findByLocationOrderByNameAsc(String location);

    List<Cafe> findByTagsContaining(String tags);

    List<Cafe> findByNameOrderByNameAsc(String location);

}