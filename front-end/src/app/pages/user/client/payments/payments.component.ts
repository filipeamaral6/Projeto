import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';
import { Account } from 'app/shared/models/Account';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

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
  paymentForm: FormGroup;
  isEyeOpen: boolean;


  constructor(
    private clientLayout: ClientLayoutComponent,
    private formBuilder: FormBuilder,
  ) {
    this.clientLayout.refreshData();
    this.client = this.clientLayout.getClient;
  }

  ngOnInit() {
    this.isEyeOpen = false;

    this.paymentForm = this.formBuilder.group({
      type: ['', Validators.required],
      accountIban: ['', Validators.required],
      clientId: ['', Validators.required],
      value: ['', Validators.required],
      cents: ['', Validators.required, Validators.min(0), Validators.max(99)],
      description: ['', Validators.required, Validators.maxLength(200)],
      entity: ['', Validators.required, Validators.min(0), Validators.max(99999)],
      reference: ['', Validators.required, Validators.min(0), Validators.max(999999999)]
    });
  }

  get f() {
    return this.paymentForm.controls;
  }

  selectAccount(accountId: number) {
    console.log('payments' + accountId);
    // this.selectedAccount = this.clientLayout.getAccountById( accountId )[0];
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

}
