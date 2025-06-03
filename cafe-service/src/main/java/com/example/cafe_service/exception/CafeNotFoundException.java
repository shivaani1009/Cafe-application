package com.example.cafe_service.exception;

public class CafeNotFoundException extends RuntimeException {
    public CafeNotFoundException(String message) {
        super(message);
    }
}