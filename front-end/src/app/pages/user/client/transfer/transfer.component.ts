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

  selectedAccount: Account = null;
  isEyeOpen = false;
  // accounts: Account[];

  constructor(
    private clientLayout: ClientLayoutComponent,
  ) { }

  ngOnInit() {
    // this.accounts = this.getAccountList();
  }

  getAccountList() {
    return this.clientLayout.getAccounts;
  }
  resetForm() {
    console.log('Reset');
  }

  cancelFunction() {
    this.selectAccount = null;
    console.log('Cancel');
  }

  onSubmit() {
    console.log('Submit');
  }

  digitOnly(event: { which: any; keyCode: any; }): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;

  }

  showPass() {
    if ( !this.isEyeOpen ) {
      this.isEyeOpen = true;
    } else {
      this.isEyeOpen = false;
    }
  }

  selectAccount(account: Account) {
    this.selectedAccount = account;
  }

}
