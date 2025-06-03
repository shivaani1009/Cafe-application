package com.example.cafe_service.repository;

import com.example.cafe_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByName(String name);
}