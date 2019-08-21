import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';
import { Account } from 'app/shared/models/Account';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'payments-cmp',
  moduleId: module.id,
  templateUrl: 'payments.component.html',
  styleUrls: ['payments.component.css']
})

export class PaymentsComponent implements OnInit {

  client: Client;
  selectedAccount: Account = null;

  constructor(
    private clientLayout: ClientLayoutComponent
  ) {
    this.clientLayout.refreshData();
    this.client = this.clientLayout.getClient;
  }

  ngOnInit() {

  }

  selectAccount(accountId: number) {
    console.log('payments' + accountId);
    // this.selectedAccount = this.clientLayout.getAccountById( accountId )[0];
  }

  getAccountList() {
    return this.clientLayout.getAccounts;
  }

}
