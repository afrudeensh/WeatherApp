package com.example.response;

import com.example.DTO.GNewsArticleDTO;

import java.util.ArrayList;
import java.util.List;

public class GNewsResponse {

    private int totalArticles = 0;
    private List<GNewsArticleDTO> articles = new ArrayList<>();

    public void setTotalAmounts(int totalArticles) {
        this.totalArticles = totalArticles;
    }

    public int getTotalArticles() {
        return totalArticles;
    }

    public void setArticles(List<GNewsArticleDTO> articles) {
        this.articles = articles;
    }

    public List<GNewsArticleDTO> getArticles() {
        return articles;
    }
}
