package com.cafeflow.cafeservice.repository;

import com.cafeflow.cafeservice.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByName(String name);
}