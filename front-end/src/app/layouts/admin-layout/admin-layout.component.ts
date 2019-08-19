import { Component, OnInit } from '@angular/core';
import { CurrentUser } from 'app/shared/models/CurrentUser';
import { Client } from 'app/shared/models/Client';
import { Account } from 'app/shared/models/Account';
import { AuthenticationService } from 'app/services/authentication.service';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { AccountService } from 'app/services/transport/account.service';


@Component({
  selector: 'app-admin-layout',
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.scss']
})

export class AdminLayoutComponent implements OnInit {
  private client: Client;
  private accounts: Account[];

  public get getClient() {
    return this.client;
  }

  public get getAccounts() {
    return this.accounts;
  }

  constructor(
    private authenticationService: AuthenticationService,
    private clientService: ClientService,
    private accountService: AccountService
    ) {}
  ngOnInit() {
    this.getClientInfo();
    // this.getClientAccounts();
   }

  private getClientInfo() {
    /*
     *  Receber o ID do cliente pelo url!!
     *
     *
     */
      this.clientService.getById(this.authenticationService.currentUser.id).pipe(first()).subscribe( client => {
      this.client = client[0];
      console.log(this.client);
  });
  }

  // private getClientAccounts() {
  //  this.accountService.getById(this.currentUser.id).pipe(first()).subscribe( accounts => {
  //    this.accounts = accounts;
  //  })
  // }

    // private getClientMovements() {

    // }

  public refreshData() {
    this.getClientInfo();
    // this.getClientAccounts();
    // this.getClientMovements();
  }

}
