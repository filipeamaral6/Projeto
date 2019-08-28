import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { HomeComponent } from './home/home.component'
import { ClientLayoutComponent } from './layouts/client-layout/client-layout.component';
import { WorkerLayoutComponent } from './layouts/worker-layout/worker-layout.component';
import { ClientGuard } from './guards/client.guard';
import { EmployeeGuard } from './guards/employee.guard';
import { LoginGuard } from './guards/login.guard';


export const AppRoutes: Routes = [

  {
    path: 'home',
    component: HomeComponent, canActivate: [LoginGuard]
  },

  // {
  //   path: 'dashboard',
  //   redirectTo: 'dashboard-cmp',
  //   pathMatch: 'full',
  // },

  {
    path: 'client',
    component: ClientLayoutComponent, canActivate: [ClientGuard],
    loadChildren: () => import('./layouts/client-layout/client-layout.module').then(mod => mod.ClientLayoutModule)
  },

  {
    path: 'worker',
    component: WorkerLayoutComponent, canActivate: [EmployeeGuard],
    loadChildren: () => import('./layouts/worker-layout/worker-layout.module').then(mod => mod.WorkerLayoutModule)
  },

  {
    path: '**',
    redirectTo: 'home'
  }
]
