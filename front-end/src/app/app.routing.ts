import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { HomeComponent } from './home/home.component'
import { ClientLayoutComponent } from './layouts/client-layout/client-layout.component';
import { AuthGuard } from './guards/auth.guard';
import { WorkerLayoutComponent } from './layouts/worker-layout/worker-layout.component';


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
    path: 'client',
    component: ClientLayoutComponent, canActivate: [AuthGuard],
    children: [
      {
        path: 'client',
        loadChildren: './layouts/client-layout/client-layout.module#ClientLayoutModule'
      }]
  },

  {
    path: 'worker',
    component: WorkerLayoutComponent, canActivate: [AuthGuard],
    loadChildren: () => import('./layouts/worker-layout/worker-layout.module').then(mod => mod.WorkerLayoutModule)
  },

  {
    path: '**',
    redirectTo: 'home'
  }
]
