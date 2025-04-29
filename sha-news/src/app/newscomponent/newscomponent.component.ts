import { Component, OnInit } from '@angular/core';
import { NewsService } from '../newsservice.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-newscomponent',
  standalone: true,
  imports: [CommonModule,HttpClientModule],
  templateUrl: './newscomponent.component.html',
  styleUrl: './newscomponent.component.css'
})
export class Newscomponent implements OnInit {
  articles: any[] = [];
  isLoading: boolean = true;

  constructor(private newsService: NewsService) {}

  ngOnInit(): void {
    this.loadLatestNews();
  }

  loadLatestNews() {
    this.newsService.getLatestNews().subscribe({
      next: (response) => {
        this.articles = response.articles;
        this.isLoading = false;
      },
      error: (error) => {
        console.error('Error fetching news:', error);
        this.isLoading = false;
      }
    });
  }


}
