import { Component, OnInit, Input } from '@angular/core';
import { DashboardComponent } from 'app/pages/user/client/dashboard/dashboard.component';
import { MovementsComponent } from 'app/pages/user/client/movements/movements.component';
import { PaymentsComponent } from 'app/pages/user/client/payments/payments.component';
import { TransferComponent } from 'app/pages/user/client/transfer/transfer.component';
import { Account } from 'app/shared/models/Account';

@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {

  // @Input() accountList: Account[];
  // @Input() callingPageName: string;

  private selectedAccount: Account;
  accountList: Account[];
  account1: Account;
  account2: Account;
  account3: Account;

  constructor(
    // private dashboardComponent: DashboardComponent,
    // private movementsComponent: MovementsComponent,
    // private paymentsComponent: PaymentsComponent,
    // private transferComponent: TransferComponent,
  ) { }

  ngOnInit() {
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

  sendSelectedAccount(index: number) {

    this.selectedAccount = this.accountList[index];
    console.log(index);


    // if ( this.callingPageName === 'DASHBOARD' ) {
    //   this.dashboardComponent.selectAccount(this.selectedAccount.accountNumber);
    // }
    // if ( this.callingPageName === 'MOVEMENTS' ) {
    //   this.movementsComponent.selectAccount(this.selectedAccount.accountNumber);
    // }
    // if ( this.callingPageName === 'PAYMENTS' ) {
    //   this.paymentsComponent.selectAccount(this.selectedAccount.accountNumber);
    // }
    // if ( this.callingPageName === 'TRANSFER' ) {
    //   this.transferComponent.selectAccount(this.selectedAccount.accountNumber);
    // }
  }

}
