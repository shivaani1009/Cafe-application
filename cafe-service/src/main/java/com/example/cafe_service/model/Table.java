package com.example.cafe_service.model;
import jakarta.persistence.*;

@Entity
public class Table{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    public Integer number;
    public Boolean isOccupied;
    public Integer seats;
    public Integer cafeId;
}