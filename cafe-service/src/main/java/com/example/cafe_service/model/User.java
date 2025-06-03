package com.example.cafe_service.model;
import jakarta.persistence.*;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer number;
}