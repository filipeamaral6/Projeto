import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { HomeComponent} from './home/home.component'
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
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
    path: 'dashboard',
    component: AdminLayoutComponent, canActivate: [AuthGuard],
    children: [
        {
      path: '',
      loadChildren: './layouts/admin-layout/admin-layout.module#AdminLayoutModule'
  }]},

  {
   path: '**',
   redirectTo: 'home'
  }
]
