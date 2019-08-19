import { Component, OnInit } from '@angular/core';
import { CurrentUser } from 'app/shared/models/CurrentUser';
import { Client } from 'app/shared/models/Client';
import { Account } from 'app/shared/models/Account';
import { AuthenticationService } from 'app/services/authentication.service';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { AccountService } from 'app/services/transport/account.service';


@Component({
  selector: 'app-client-layout',
  templateUrl: './client-layout.component.html',
  styleUrls: ['./client-layout.scss']
})

export class ClientLayoutComponent implements OnInit {
  private currentUser: CurrentUser;
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
    ) {
      this.currentUser = this.authenticationService.currentUser;
    }
  ngOnInit() {
    this.getClientInfo();
    // this.getClientAccounts();
   }

   private getClientInfo() {

    this.clientService.getById(this.currentUser.id).pipe(first()).subscribe( client => {
      this.client = client[0];
      console.log(this.client);
    });
    }

    // private getClientAccounts() {
    //   this.accountService.getById(this.currentUser.id).pipe(first()).subscribe( accounts => {
    //     this.accounts = accounts;
    //   })
    // }

    private getClientMovements() {

    }

    public refreshData() {
      this.getClientInfo();
      // this.getClientAccounts();
      // this.getClientMovements();
    }
}
