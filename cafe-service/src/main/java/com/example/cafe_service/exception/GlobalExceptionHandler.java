package com.example.cafe_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.cafe_service.exception.CafeNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CafeNotFoundException.class)
    public ResponseEntity<?> handleCafeNotFound(CafeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
