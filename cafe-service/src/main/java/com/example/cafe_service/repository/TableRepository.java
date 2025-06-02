package com.cafeflow.cafeservice.repository;

import com.cafeflow.cafeservice.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TableRepository extends JpaRepository<Table, Integer>{
    List<Table> findByIsOccupiedFalse();

    List<Table> findByCafeId();

    List<Table> findBySeatsGreaterThanEqual(Integer seats);

}