package com.example.cafe_service.model;
import jakarta.persistence.*;

@Entity
public class Owner{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public Integer cafeId;
}