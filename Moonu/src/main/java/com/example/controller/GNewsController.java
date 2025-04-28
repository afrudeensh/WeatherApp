package com.example.controller;

import com.example.response.GNewsResponse;
import com.example.response.NewsResponse;
import com.example.service.GNewsService;
import com.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gnews/v2")
public class GNewsController {
    @Autowired
    private GNewsService gNewsService;

    @GetMapping("/latest-news")
    public GNewsResponse getLatestNews(@RequestParam(defaultValue = "general") String category) {
        return gNewsService.getLatestNews(category);
    }
}
