import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { Account } from 'app/shared/models/Account';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ClientService } from 'app/services/transport/client.service';
import { AuthenticationService } from 'app/services/authentication.service';
import { Payment } from 'app/shared/models/Payment';
import { TransactionService } from 'app/services/transport/transaction.service';
import { first } from 'rxjs/operators';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'payments-cmp',
  moduleId: module.id,
  templateUrl: 'payments.component.html',
  styleUrls: ['payments.component.css']
})

export class PaymentsComponent implements OnInit {

  selectedAccount: Account;
  paymentForm: FormGroup;
  isEyeOpen: boolean;
  submitted = false;


  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private transactionService: TransactionService,
  ) {}

  ngOnInit() {
    this.selectedAccount = null;

    this.initForm();
  }

  get f() {
    return this.paymentForm.controls;
  }

  resetForm() {
    this.ngOnInit();
  }

  cancelFunction() {
    this.selectedAccount = null;
    this.ngOnInit();
  }

  onSubmit() {
    console.log('Submit');
    this.submitted = true;

    this.paymentForm.value.employeeId = 0;
    this.paymentForm.value.type = 'Pagamento';
    this.paymentForm.value.userId = this.authenticationService.currentUser.id;
    this.paymentForm.value.accountIban = this.selectedAccount.iban;
    this.paymentForm.value.accountId = this.selectedAccount.id;

    this.paymentForm.value.value = this.paymentForm.value.euros + '.' + this.paymentForm.value.cents;

    console.log( this.paymentForm.value );

    if ( this.paymentForm.invalid ) {
      console.log(1);
      this.ngOnInit();
      return;
    }


    this.transactionService.addPayment(this.paymentForm.value).pipe(first()).subscribe( response => {
      console.log(response);
    });
    this.ngOnInit();

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

  initForm() {

    this.isEyeOpen = false;

    this.paymentForm = this.formBuilder.group({
      employeeId: ['', Validators.required],
      userId: ['', Validators.required],
      type: ['', Validators.required],
      value: ['', Validators.required],
      euros: ['', Validators.required],
      cents: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
      description: ['', [Validators.required, Validators.maxLength(200)]],
      entity: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(5)]],
      reference: ['', [Validators.required, Validators.minLength(9), Validators.maxLength(9)]],
      transactionCode: ['', Validators.required]
    });
  }

}
