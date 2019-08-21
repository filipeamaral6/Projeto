import { Component, OnInit, Input } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { DashboardComponent } from 'app/pages/user/client/dashboard/dashboard.component';
import { MovementsComponent } from 'app/pages/user/client/movements/movements.component';
import { PaymentsComponent } from 'app/pages/user/client/payments/payments.component';
import { TransferComponent } from 'app/pages/user/client/transfer/transfer.component';
import { AuthenticationService } from 'app/services/authentication.service';


@Component({
  selector: 'app-account-list',
  templateUrl: './account-list.component.html',
  styleUrls: ['./account-list.component.css']
})
export class AccountListComponent implements OnInit {

  @Input() private component: any;

  accountInfoPopUp: boolean;
  accountList: Account[];
  selectedAccount: Account;

  constructor(
    private authenticationService: AuthenticationService,
  ) { }

  ngOnInit() {

    this.accountList  = [];
    this.selectedAccount = null;
    this.accountInfoPopUp = false;

    this.initAccountList();
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

  private initAccountList() {
    if ( this.authenticationService.currentUser.role === 'CLIENT' ) {
      if ( (this.component instanceof DashboardComponent) || (this.component instanceof MovementsComponent) ) {
        this.accountInfoPopUp = true;
        this.accountList = this.component.getAccountList();
      }
      if ( ((this.component instanceof PaymentsComponent) || (this.component instanceof TransferComponent)) ) {
        this.component.getAccountList().forEach(account => {
          if ( account.type.toLowerCase() !== 'poupança') {
            console.log(account.id);
            this.accountList.push(account);
            console.log(this.accountList);
          }
        });
      }
    }
    if ( (this.authenticationService.currentUser.role === 'OPERATOR') || (this.authenticationService.currentUser.role === 'ADMIN') ) {
      if ( (this.component instanceof DashboardComponent) || (this.component instanceof MovementsComponent) ) {
        this.accountInfoPopUp = true;
        this.accountList = this.component.getAccountList();
      }
      if ( this.component instanceof PaymentsComponent ) {
        this.component.getAccountList().forEach(account => {
          if ( account.type.toLowerCase() !== 'poupança') {
            console.log(account.id);
            this.accountList.push(account);
            console.log(this.accountList);
          }
        });
      }
    }
  }

}
