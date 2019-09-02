import { Component, OnInit } from '@angular/core';
import { CurrentUser } from 'app/shared/models/CurrentUser';
import { Account } from 'app/shared/models/Account';
import { AuthenticationService } from 'app/services/authentication.service';
import { AccountService } from 'app/services/transport/account.service';
import { RouteInfo } from 'app/shared/sidebar/sidebar.component';
import { User } from 'app/shared/models/User';

const RoutesEmployee = [
  { path: 'clients', title: 'Clientes', icon: 'nc-single-02', class: '' },
  { path: 'accounts', title: 'Contas', icon: 'nc-bank', class: '' },
  { path: 'deposit', title: 'Depositar', icon: 'nc-box', class: '' },
  { path: 'withdraw', title: 'Levantar', icon: 'nc-money-coins', class: '' },
  { path: 'transfer', title: 'Transferir', icon: 'nc-send', class: '' },
  { path: 'payments', title: 'Pagamentos', icon: 'nc-cart-simple', class: '' },
];

const RoutesAdmin = [
  { path: 'employees', title: 'Colaboradores', icon: 'nc-badge', class: '' },
  { path: 'clients', title: 'Clientes', icon: 'nc-single-02', class: '' },
  { path: 'accounts', title: 'Contas', icon: 'nc-bank', class: '' },
  { path: 'deposit', title: 'Depositar', icon: 'nc-box', class: '' },
  { path: 'withdraw', title: 'Levantar', icon: 'nc-money-coins', class: '' },
  { path: 'transfer', title: 'Transferir', icon: 'nc-send', class: '' },
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

  constructor(
    private authenticationService: AuthenticationService,
    private accountService: AccountService
  ) { }

  ngOnInit() {
    this.currentUser = this.authenticationService.currentUser;
    if (this.currentUser.role === 'ADMIN') {
      this.routes = RoutesAdmin;
    } else {
      this.routes = RoutesEmployee;
    }
  }

  public get getWorker() {
    return this.client;
  }

  public get getAccounts() {
    return this.accounts;
  }
}
