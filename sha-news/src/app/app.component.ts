import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Newscomponent } from './newscomponent/newscomponent.component';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,Newscomponent,HttpClientModule,],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'sha-news';
}
