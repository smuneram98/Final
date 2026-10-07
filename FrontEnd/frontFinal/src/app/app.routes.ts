import { Routes } from '@angular/router';
import { DashboardComponent } from './view/dashboard.component/dashboard.component/dashboard.component';

export const routes: Routes = [
    {path: 'home',component: DashboardComponent},
    {path: '**', redirectTo: '/home'}
];
