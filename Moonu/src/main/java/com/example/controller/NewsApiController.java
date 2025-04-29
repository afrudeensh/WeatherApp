package com.example.controller;

import com.example.response.NewsResponse;
import com.example.response.SourceResponse;
import com.example.service.NewsService;
import com.example.utils.NewsApiDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/news/v2")
public class NewsApiController {

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

        if(language == null || !NewsApiDefaults.isValidLanguage(language)){
            language = NewsApiDefaults.DEFAULT_LANGUAGE;
        }
        if (country == null || !NewsApiDefaults.isValidCountry(country)) {
            country = NewsApiDefaults.DEFAULT_COUNTRY;
        }

        return newsService.getSources(
                category != null ? category : "",
                language,
                country
        );
    }
    @GetMapping("/date")
    public NewsResponse getNewsByDateRange(@RequestParam String query,
                                           @RequestParam String from,
                                           @RequestParam String to) {
        return newsService.getNewsByDateRange(query, from, to);
    }

}
