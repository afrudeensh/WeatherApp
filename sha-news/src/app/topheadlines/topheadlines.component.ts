import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { NewsService } from '../newsservice.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-topheadlines',
  standalone: true,
  imports: [CommonModule,HttpClientModule,FormsModule],
  templateUrl: './topheadlines.component.html',
  styleUrl: './topheadlines.component.css'
})
export class TopheadlinesComponent {
  headlines: any[] = [];
  everything: any[] = [];
  isLoading = false;

  categories = ['business', 'entertainment', 'health', 'science', 'sports', 'technology'];
  selectedCategory: string = '';
  searchQuery: string = '';

  constructor(private newsService: NewsService) {}

  fetchTopHeadlines() {
    if (this.selectedCategory) {
      this.isLoading = true;
      this.headlines = [];
      this.everything = [];
      this.newsService.getTopHeadlines(this.selectedCategory).subscribe(
        (response) => {
          this.headlines = response.articles || [];
          this.isLoading = false;
        },
        (error) => {
          console.error('Error fetching top headlines:', error);
          this.isLoading = false;
        }
      );
    }
  }

  fetchEverything() {
    if (this.searchQuery.trim()) {
      this.isLoading = true;
      this.headlines = [];
      this.everything = [];
      this.newsService.getEverything(this.searchQuery).subscribe(
        (response) => {
          this.everything = response.articles || [];
          this.isLoading = false;
        },
        (error) => {
          console.error('Error fetching everything:', error);
          this.isLoading = false;
        }
      );
    }
  }
}
