import { Component, OnInit } from '@angular/core';
import { CurrentUser } from 'app/shared/models/CurrentUser';
import { Account } from 'app/shared/models/Account';
import { AuthenticationService } from 'app/services/authentication.service';
import { AccountService } from 'app/services/transport/account.service';
import { RouteInfo } from 'app/shared/sidebar/sidebar.component';

const ROUTES = [
  { path: 'employees', title: 'Colaboradores', icon: 'nc-badge', class: '' },
  { path: 'clients', title: 'Clientes', icon: 'nc-single-02', class: '' },
  { path: 'deposit', title: 'Depositar', icon: 'nc-box', class: '' },
  { path: 'transfer', title: 'Transferir', icon: 'nc-money-coins', class: '' },
  { path: 'payments', title: 'Pagamentos', icon: 'nc-cart-simple', class: '' },
];

@Component({
  selector: 'app-worker-layout',
  templateUrl: './worker-layout.component.html',
  styleUrls: ['./worker-layout.scss']
})

export class WorkerLayoutComponent implements OnInit {
  private currentUser: CurrentUser;
  private client: Worker;
  private accounts: Account[];
  routes: RouteInfo[];

  ngOnInit() {
    this.routes = ROUTES;
  }

  public get getWorker() {
    return this.client;
  }

  public get getAccounts() {
    return this.accounts;
  }

  constructor(
    private authenticationService: AuthenticationService,
    private accountService: AccountService
  ) {
    this.currentUser = this.authenticationService.currentUser;
  }
}
