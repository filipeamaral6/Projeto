import { Component, OnInit } from '@angular/core';
import { CurrentUser } from 'app/shared/models/CurrentUser';
import { Client } from 'app/shared/models/Client';
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
  private currentUser: CurrentUser;
  private client: Client;



  routes: RouteInfo[];

  accountList: Account[];
  account1: Account;
  account2: Account;
  account3: Account;

  constructor(
    private authenticationService: AuthenticationService,
    private clientService: ClientService,
    private accountService: AccountService
  ) {
    this.currentUser = this.authenticationService.currentUser;
  }


  ngOnInit() {
    this.routes = ROUTES;
    this.initAccounts();
    // this.getClientInfo();
    // this.getClientAccounts();
  }

  public get getClient() {
    return this.client;
  }

  public get getAccounts() {
    return this.accountList;
  }

  public getAccountById(accountId: number) {
    return this.accountService.getById(accountId).pipe(first());
  }



  // private getClientInfo() {

  //   this.clientService.getById(this.currentUser.id).pipe(first()).subscribe(client => {
  //     this.client = client[0];
  //     console.log(this.client);
  //   });
  // }

  // private getClientAccounts() {
  //   this.accountService.getById(this.currentUser.id).pipe(first()).subscribe( accounts => {
  //     this.accounts = accounts;
  //   })
  // }

  private getClientMovements() {

  }

  public refreshData() {
    // this.getClientInfo();
    // this.getClientAccounts();
    // this.getClientMovements();
  }

  initAccounts() {
    this.account1 = {
      id: 1,
      type: 'Ordem',
      iban: 'PT500001000000001',
      accountNumber: 1000000001,
      balance: 500,
      interest: 0.001,
      status: 'ACTIVE',
      createdAt: new Date(),
      employeeId: 123456789,
    },
    this.account2 = {
      id: 2,
      type: 'Ordem',
      iban: 'PT500001000000002',
      accountNumber: 1000000002,
      balance: 500,
      interest: 0.001,
      status: 'ACTIVE',
      createdAt: new Date(),
      employeeId: 123456789,
    },
    this.account3 = {
      id: 3,
      type: 'Poupança',
      iban: 'PT500001000000003',
      accountNumber: 1000000003,
      balance: 500,
      interest: 0.001,
      status: 'ACTIVE',
      createdAt: new Date(),
      employeeId: 123456789,
    }
    this.accountList = [ this.account1, this.account2, this.account3 ];
  }

}
