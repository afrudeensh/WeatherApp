package com.example.response;

import com.example.DTO.ArticleDTO;

import java.util.ArrayList;
import java.util.List;

public class NewsResponse {
    private String status ="error";
    private int totalResults =0;
    private List<ArticleDTO> articles = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }
}
