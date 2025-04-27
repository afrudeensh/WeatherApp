package com.example.controller;

import com.example.service.CatFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatFactController {

    @Autowired
    private CatFactService catFactService;

    @GetMapping("/ping")
    public String ping() {
        return "Application is running!";
    }


    @GetMapping("/get-post")
    public String fetchPost() {
        return catFactService.getPost();
    }
}