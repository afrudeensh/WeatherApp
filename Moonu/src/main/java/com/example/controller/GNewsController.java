package com.example.controller;

import com.example.response.GNewsResponse;
import com.example.response.NewsResponse;
import com.example.service.GNewsService;
import com.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/gnews/v2")
public class GNewsController {
    @Autowired
    private GNewsService gNewsService;

    @GetMapping("/latest-news")
    public GNewsResponse getLatestNews(@RequestParam(defaultValue = "general") String category) {
        return gNewsService.getLatestNews(category);
    }
    @GetMapping("/search")
    public GNewsResponse searchGNews(@RequestParam String query,
                                    @RequestParam(required = false) String language,
                                    @RequestParam(required = false) String country) {
        return gNewsService.searchGNews(query, language, country);
    }
}
