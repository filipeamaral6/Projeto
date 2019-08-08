import { Routes } from '@angular/router';

import { Component } from '@angular/core';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent} from './pages/home/home.component'

export const AppRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'dashboard',
    redirectTo: 'dashboard',
//    pathMatch: 'full',
  },
  // {
  //   path: '',
  //   component: AdminLayoutComponent,
  //   children: [
  //       {
  //     path: '',
  //     loadChildren: './layouts/admin-layout/admin-layout.module#AdminLayoutModule'
  // }]},
//  {
//    path: '**',
//    redirectTo: 'dashboard'
//  }
]
