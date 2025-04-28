package com.example.service;

import com.example.exception.NewsApiException;
import com.example.response.GNewsResponse;
import com.example.response.NewsResponse;
import com.example.utils.NewsApiUrls;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class GNewsService {

    @Value("${gnews.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GNewsService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public GNewsResponse getLatestNews(String category) {
        String url = String.format(NewsApiUrls.GNEWS_API, category, apiKey);
        try {
            GNewsResponse response = restTemplate.getForObject(url, GNewsResponse.class);
            return response;
        } catch (RestClientException e) {
            throw new NewsApiException("Failed to fetch latest news from News API", e);
        }
    }

    public GNewsResponse searchGNews(String query, String language, String country) {
        String url = String.format(
                "https://gnews.io/api/v4/search?q=%s&lang=%s&country=%s&apiKey=%s",
                query,
                language != null ? language : "en",
                country != null ? country : "us",
                apiKey
        );

        try {
            GNewsResponse response = restTemplate.getForObject(url, GNewsResponse.class);
            if (response == null) {
                throw new NewsApiException("Invalid response from GNews API");
            }
            return response;
        } catch (RestClientException ex) {
            throw new NewsApiException("Failed to fetch news from GNews API", ex);
        }
    }

}
