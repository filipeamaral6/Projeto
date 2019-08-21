import { Component, OnInit } from '@angular/core';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';
import { Account } from 'app/shared/models/Account';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'transfer-cmp',
  moduleId: module.id,
  templateUrl: 'transfer.component.html',
  styleUrls: ['transfer.component.css']
})

export class TransferComponent implements OnInit {

  // accounts: Account[];

  constructor(
    private clientLayout: ClientLayoutComponent,
  ) {}

  ngOnInit() {
    // this.accounts = this.getAccountList();
  }

  selectAccount(accountId: number) {
    console.log('transfer' + accountId);
  }

  getAccountList() {
    return this.clientLayout.getAccounts;
  }

}
