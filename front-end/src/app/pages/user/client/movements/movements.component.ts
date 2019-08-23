import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'app/app.component';
import { Router, Route } from '@angular/router';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';
import { Account } from 'app/shared/models/Account';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'movements-cmp',
  moduleId: module.id,
  templateUrl: 'movements.component.html',
  styleUrls: ['movements.component.css']
})

export class MovementsComponent implements OnInit {
  // accounts: Account[];
  selectedAccount: Account;

  constructor(
    private appComponent: AppComponent,
    private router: Router,
    private clientLayout: ClientLayoutComponent
    ) {
      this.clientLayout.refreshData();
    }

  ngOnInit() {
    // this.accounts = this.getAccountList();
  }

  selectAccount(accountId: number) {
    console.log('movements' + accountId);
  }

  getAccountList() {
    return this.clientLayout.getAccounts;
  }

}
