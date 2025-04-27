package com.example.service;

import com.example.DTO.ArticleDTO;
import com.example.response.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsService {
    @Value("${newsapi.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NewsResponse getLatestNews(String category) {
        String url = String.format("https://newsapi.org/v2/top-headlines?category=%s&apiKey=%s", category, apiKey);
        return restTemplate.getForObject(url, NewsResponse.class);
    }
}
