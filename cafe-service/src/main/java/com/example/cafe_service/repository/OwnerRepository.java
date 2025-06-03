package com.example.cafe_service.repository;

import com.example.cafe_service.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{
    List<Owner> findByCafeId(Integer cafeId);
}