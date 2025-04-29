import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  private BASE_URL = 'http://localhost:8080/api/news/v2'; // Your Spring Boot backend

  constructor(private http: HttpClient) { }

  // Fetch Latest News
  getLatestNews(category: string = 'general'): Observable<any> {
    return this.http.get(`${this.BASE_URL}/latest-news?category=${category}`);
  }

  // Fetch Top Headlines
  getTopHeadlines(category: string): Observable<any> {
    return this.http.get(`${this.BASE_URL}/top-headlines?category=${category}`);
  }

  // Fetch Everything based on Query
  getEverything(query: string): Observable<any> {
    return this.http.get(`${this.BASE_URL}/everything?query=${query}`);
  }

  // Fetch Sources
  getSources(category?: string, language?: string, country?: string): Observable<any> {
    let url = `${this.BASE_URL}/sources?`;
    if (category) url += `category=${category}&`;
    if (language) url += `language=${language}&`;
    if (country) url += `country=${country}&`;
    return this.http.get(url);
  }

  // Fetch News by Date Range
  getNewsByDateRange(query: string, from: string, to: string): Observable<any> {
    return this.http.get(`${this.BASE_URL}/date?query=${query}&from=${from}&to=${to}`);
  }
}
