import { Component, OnInit, Input } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { DashboardComponent } from 'app/pages/user/client/dashboard/dashboard.component';
import { MovementsComponent } from 'app/pages/user/client/movements/movements.component';
import { PaymentsComponent } from 'app/pages/user/client/payments/payments.component';
import { TransferComponent } from 'app/pages/user/client/transfer/transfer.component';
import { AuthenticationService } from 'app/services/authentication.service';
import { first } from 'rxjs/operators';
import { AccountService } from 'app/services/transport/account.service';
import { AlertService } from '../alerts/alert.service';



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
  createdAt: string;

  constructor(
    private authenticationService: AuthenticationService,
    private accountService: AccountService,
    private alertService: AlertService,
  ) { }

  ngOnInit() {

    this.accountList  = [];
    this.selectedAccount = null;
    this.accountInfoPopUp = false;
    this.getClientAccounts();
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

  sendSelectedAccount(account: Account) {
    if ( this.selectedAccount !== account ) {
      this.selectedAccount = account;
      this.createdAt = this.selectedAccount.createdAt.toString().substring(0, 10);
      this.component.selectAccount(account)
    } else {
      this.selectedAccount = null;
      this.component.selectedAccount = null;
    }
  }

  private initAccountList() {
    if ( this.authenticationService.currentUser.role === 'CLIENT' ) {
      if ( (this.component instanceof DashboardComponent) || (this.component instanceof MovementsComponent) ) {
        this.accountInfoPopUp = true;
        this.getClientAccounts();
      }
      if ( ((this.component instanceof PaymentsComponent) || (this.component instanceof TransferComponent)) ) {
        this.accountList.forEach(account => {
          if ( account.type !== 'POUPANÇA') {
            this.accountList.push(account);
          }
        });
      }
    }
    if ( (this.authenticationService.currentUser.role === 'OPERATOR') || (this.authenticationService.currentUser.role === 'ADMIN') ) {
      if ( (this.component instanceof DashboardComponent) || (this.component instanceof MovementsComponent) ) {
        this.accountInfoPopUp = true;
        this.getClientAccounts();
      }
      if ( this.component instanceof PaymentsComponent ) {
        this.accountList.forEach(account => {
          if ( account.type !== 'POUPANÇA') {
            this.accountList.push(account);
          }
        });
      }
    }
  }

  private getClientAccounts() {
    this.accountList = [];

    this.accountService.getAccountByClientId(this.authenticationService.currentUser.id).pipe(first()).subscribe( accounts => {
      this.accountList = accounts;
    }, error => {
      this.alertService.error(error);
    });
  }

}
