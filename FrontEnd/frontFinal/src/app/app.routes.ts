import { Routes } from '@angular/router';
import { DashboardComponent } from './view/dashboard.component/dashboard.component/dashboard.component';
import { FileComponent } from './view/file.component/file.component/file.component';
import { FolderComponent } from './view/folder.component/folder.component/folder.component';

export const routes: Routes = [
    {path: 'home',component: DashboardComponent},
    {path: 'files',component: FileComponent},
    {path: 'folders', component: FolderComponent},
    {path: '**', redirectTo: '/home'}
];
