import { Component, OnInit } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { AuthenticationService } from 'app/services/authentication.service';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { AccountService } from 'app/services/transport/account.service';
import { RouteInfo } from 'app/shared/sidebar/sidebar.component';

const ROUTES = [
  { path: 'dashboard', title: 'Página Inicial', icon: 'nc-bank', class: '' },
  { path: 'user', title: 'Perfil', icon: 'nc-single-02', class: '' },
  { path: 'movements', title: 'Movimentos', icon: 'nc-single-copy-04', class: '' },
  { path: 'transfer', title: 'Transferências', icon: 'nc-credit-card', class: '' },
  { path: 'payments', title: 'Pagamentos', icon: 'nc-cart-simple', class: '' }
];

@Component({
  selector: 'app-client-layout',
  templateUrl: './client-layout.component.html',
  styleUrls: ['./client-layout.scss']
})

export class ClientLayoutComponent implements OnInit {

  routes: RouteInfo[];

  accountList: Account[];

  constructor(
    private authenticationService: AuthenticationService,
    private accountService: AccountService
  ) {}

  ngOnInit() {
    this.routes = ROUTES;
  }

}
