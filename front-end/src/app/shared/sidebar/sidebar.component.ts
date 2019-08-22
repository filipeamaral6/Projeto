import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';


export interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export let ROUTES: RouteInfo[] = [];

@Component({
  moduleId: module.id,
  // tslint:disable-next-line: component-selector
  selector: 'sidebar-cmp',
  templateUrl: 'sidebar.component.html',
})

export class SidebarComponent implements OnInit {
  @Input() menuItems: any[];

  constructor(private router: Router) {}

  ngOnInit() {
    // this.menuItems = [
    //   { path: '/dashboard', title: 'Página Inicial', icon: 'nc-bank', class: '' },
    //   { path: '/user', title: 'Perfil', icon: 'nc-single-02', class: '' },
    //   { path: '/movements', title: 'Movimentos', icon: 'nc-single-copy-04', class: '' },
    //   { path: '/transfer', title: 'Transferências', icon: 'nc-credit-card', class: '' },
    //   { path: '/payments', title: 'Pagamentos', icon: 'nc-cart-simple', class: '' }
    // ];
    ROUTES = this.menuItems;

    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }

  onLogout() {
    localStorage.removeItem('currentUser');
    this.router.navigate(['']);
  }
}
