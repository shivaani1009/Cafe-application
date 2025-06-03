package com.example.cafe_service.repository;

import com.example.cafe_service.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TableRepository extends JpaRepository<Table, Integer>{
    List<Table> findByIsOccupiedFalse();

    List<Table> findByCafeId(Integer cafeId);

    List<Table> findBySeatsGreaterThanEqual(Integer seats);

}