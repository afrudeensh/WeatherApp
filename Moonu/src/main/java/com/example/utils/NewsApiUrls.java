package com.example.utils;

public class NewsApiUrls {
    public static final String TOP_HEADLINES_API = "https://newsapi.org/v2/top-headlines?category=%s&apiKey=%s";
    public static final String EVERYTHING_API = "https://newsapi.org/v2/everything?q=%s&apiKey=%s";
    public static final String SOURCES_API = "https://newsapi.org/v2/top-headlines/sources?category=%s&language=%s&country=%s&apiKey=%s";
    public static final String DATE_RANGE_API = "https://newsapi.org/v2/everything?q=%s&from=%s&to=%s&apiKey=%s";
    public static final String GNEWS_API = "https://gnews.io/api/v4/top-headlines?category=%s&apikey=%s";
    public static final String GNEWS_API_SEARCH = "https://gnews.io/api/v4/search?q=%s&lang=%s&country=%s&apiKey=%s";
}
