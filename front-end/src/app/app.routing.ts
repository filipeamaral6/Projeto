import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { HomeComponent } from './home/home.component'
import { ClientLayoutComponent } from './layouts/client-layout/client-layout.component';
import { AuthGuard } from './guards/auth.guard';
import { WorkerLayoutComponent } from './layouts/worker-layout/worker-layout.component';
import { AccountListComponent } from './shared/account-list/account-list.component';


export const AppRoutes: Routes = [

  {
    path: 'home',
    component: HomeComponent
  },

  {
    path: 'test',
    component: AccountListComponent
  },

  // {
  //   path: 'dashboard',
  //   redirectTo: 'dashboard-cmp',
  //   pathMatch: 'full',
  // },

  {
    path: 'client',
    component: ClientLayoutComponent, canActivate: [AuthGuard],
    loadChildren: () => import('./layouts/client-layout/client-layout.module').then(mod => mod.ClientLayoutModule)
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
