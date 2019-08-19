import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { HomeComponent} from './home/home.component'
import { WorkerLayoutComponent } from './layouts/worker-layout/worker-layout.component';
import { AuthGuard } from './guards/auth.guard';


export const AppRoutes: Routes = [

  {
    path: 'home',
    component: HomeComponent
  },

  // {
  //   path: 'dashboard',
  //   redirectTo: 'dashboard-cmp',
  //   pathMatch: 'full',
  // },

  {
    path: '',
    component: WorkerLayoutComponent, canActivate: [AuthGuard],
    children: [
        {
      path: '',
      loadChildren: './layouts/worker-layout/worker-layout.module#WorkerLayoutModule'
  }]},

  {
   path: '**',
   redirectTo: 'home'
  }
]
