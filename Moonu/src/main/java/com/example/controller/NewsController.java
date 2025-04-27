package com.example.controller;

import com.example.DTO.ArticleDTO;
import com.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/latest-news")
    public List<ArticleDTO> getLatestNews(@RequestParam(defaultValue = "general") String category) {
        return newsService.getLatestNews(category);
    }
}
