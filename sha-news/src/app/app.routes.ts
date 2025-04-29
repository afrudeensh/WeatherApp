import { Routes } from '@angular/router';
import { TopheadlinesComponent } from './topheadlines/topheadlines.component';

export const routes: Routes = [
    { path: 'latest-news', component: TopheadlinesComponent },
    { path: '', redirectTo: '/latest-news', pathMatch: 'full' },
];
