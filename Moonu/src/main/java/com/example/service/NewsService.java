package com.example.service;

import com.example.DTO.ArticleDTO;
import com.example.exception.NewsApiException;
import com.example.response.NewsResponse;
import com.example.response.SourceResponse;
import com.example.utils.NewsApiUrls;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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
        String url = String.format(NewsApiUrls.TOP_HEADLINES_API, category, apiKey);
        try {
            NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);
            if (response == null || !"ok".equalsIgnoreCase(response.getStatus())) {
                throw new NewsApiException("Invalid response from News API");
            }
            return response;
        }catch(RestClientException e){
            throw new NewsApiException("Failed to fetch latest news from News API", e);
        }
    }
    // 1. Fetch Top Headlines
    public NewsResponse getTopHeadlines(String category) {
        String url = String.format(NewsApiUrls.TOP_HEADLINES_API, category, apiKey);
        return fetchNews(url);
    }

    // 2. Fetch Everything (all articles)
    public NewsResponse getEverything(String query) {
        String url = String.format(NewsApiUrls.EVERYTHING_API, query, apiKey);
        return fetchNews(url);
    }

    // 3. Fetch Sources
    public SourceResponse getSources(String category, String language, String country) {
        String url = String.format(NewsApiUrls.SOURCES_API,
                category, language, country, apiKey);
        try {
            SourceResponse response = restTemplate.getForObject(url, SourceResponse.class);
            if (response == null || !"ok".equalsIgnoreCase(response.getStatus())) {
                throw new NewsApiException("Invalid response from News Sources API");
            }
            return response;
        } catch (RestClientException ex) {
            throw new NewsApiException("Failed to fetch news sources from News API", ex);
        }
    }

    // Private common method to fetch news articles
    private NewsResponse fetchNews(String url) {
        try {
            NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);
            if (response == null || !"ok".equalsIgnoreCase(response.getStatus())) {
                throw new NewsApiException("Invalid response from News API");
            }
            return response;
        } catch (RestClientException ex) {
            throw new NewsApiException("Failed to fetch news from News API", ex);
        }
    }

}
