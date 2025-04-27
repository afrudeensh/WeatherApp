package com.example.controller;

import com.example.response.NewsResponse;
import com.example.response.SourceResponse;
import com.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/latest-news")
    public NewsResponse getLatestNews(@RequestParam(defaultValue = "general") String category) {
        return newsService.getLatestNews(category);
    }

    // 1. Top headlines
    @GetMapping("/top-headlines")
    public NewsResponse getTopHeadlines(@RequestParam String category) {
        return newsService.getTopHeadlines(category);
    }

    // 2. Everything
    @GetMapping("/everything")
    public NewsResponse getEverything(@RequestParam String query) {
        return newsService.getEverything(query);
    }

    // 3. Sources
    @GetMapping("/sources")
    public SourceResponse getSources(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) String language,
                                     @RequestParam(required = false) String country) {
        return newsService.getSources(
                category != null ? category : "",
                language != null ? language : "en",
                country != null ? country : "us"
        );
    }
}
