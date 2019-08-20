import { Component, OnInit, Input } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { DashboardComponent } from 'app/pages/user/client/dashboard/dashboard.component';
import { MovementsComponent } from 'app/pages/user/client/movements/movements.component';


@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {

  accountInfoPopUp = false;

  @Input() private component: any;

  accountList: Account[];
  selectedAccount: Account = null;

  constructor() { }

  ngOnInit() {
    this.accountList = this.component.getAccountList();
    if ( (this.component instanceof DashboardComponent) || (this.component instanceof MovementsComponent) ) {
      this.accountInfoPopUp = true;
    }
  }

  selectedStyle(accountId: number) {
    let style = {
      'background-color': 'white'
    }
    if ( this.selectedAccount === null ) {
      return style;
    } else {
      if ( accountId === this.selectedAccount.id ) {
        style = {
          'background-color': '#E1F5FE'
        }
      }
      return style;
    }
  }

  sendSelectedAccount(index: number) {

    this.selectedAccount = this.accountList[index - 1];
    this.component.selectAccount(this.selectedAccount.id);
  }
}
