import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { HomeComponent} from './home/home.component'
import { ClientLayoutComponent } from './layouts/client-layout/client-layout.component';
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
    component: ClientLayoutComponent, canActivate: [AuthGuard],
    children: [
        {
      path: '',
      loadChildren: './layouts/client-layout/client-layout.module#ClientLayoutModule'
  }]},

  {
   path: '**',
   redirectTo: 'home'
  }
]
