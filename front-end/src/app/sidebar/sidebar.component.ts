import { Component, OnInit } from '@angular/core';


export interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  { path: '/dashboard', title: 'Página Inicial', icon: 'nc-bank', class: '' },
  { path: '/user', title: 'Perfil', icon: 'nc-single-02', class: '' },
  { path: '/movements', title: 'Movimentos', icon: 'nc-single-copy-04', class: '' },
  { path: '/transfer', title: 'Transferências', icon: 'nc-credit-card', class: '' },
  { path: '/payments', title: 'Pagamentos', icon: 'nc-cart-simple', class: '' }
];

@Component({
  moduleId: module.id,
  // tslint:disable-next-line: component-selector
  selector: 'sidebar-cmp',
  templateUrl: 'sidebar.component.html',
})

export class SidebarComponent implements OnInit {
  public menuItems: any[];
  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
}
