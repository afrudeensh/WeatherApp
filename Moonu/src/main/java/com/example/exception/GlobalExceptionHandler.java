package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NewsApiException.class)
    public ResponseEntity<String> handleNewsApiException(NewsApiException ex) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("News API Error: " + ex.getMessage());
    }
}