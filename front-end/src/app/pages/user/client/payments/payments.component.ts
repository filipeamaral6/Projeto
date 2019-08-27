import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';
import { Account } from 'app/shared/models/Account';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ClientService } from 'app/services/transport/client.service';
import { AuthenticationService } from 'app/services/authentication.service';
import { Payment } from 'app/shared/models/Payment';
import { TransactionService } from 'app/services/transport/transaction.service';
import { first } from 'rxjs/operators';
import { NodeCompatibleEventEmitter } from 'rxjs/internal/observable/fromEvent';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'payments-cmp',
  moduleId: module.id,
  templateUrl: 'payments.component.html',
  styleUrls: ['payments.component.css']
})

export class PaymentsComponent implements OnInit {

  centString: string;
  cents: number;
  totalValue: number;

  client: Client;
  newPayment: Payment;
  selectedAccount: Account = null;
  paymentForm: FormGroup;
  isEyeOpen: boolean;
  submitted = false;


  constructor(
    private formBuilder: FormBuilder,
    private clientService: ClientService,
    private authenticationService: AuthenticationService,
    private transactionService: TransactionService,
  ) {}

  ngOnInit() {
    this.isEyeOpen = false;
    this.newPayment = new Payment;

    // this.client = this.clientService.getById(this.authenticationService.currentUser.id);


    this.paymentForm = this.formBuilder.group({
      userId: ['', Validators.required],
      type: ['', Validators.required],
      accountIban: ['', Validators.required],
      clientId: ['', Validators.required],
      value: ['', Validators.required],
      cents: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
      description: ['', [Validators.required, Validators.maxLength(200)]],
      entity: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(5)]],
      reference: ['', [Validators.required, Validators.minLength(9), Validators.maxLength(9)]],
      transactionCode: ['', Validators.required]
    });
  }

  get f() {
    return this.paymentForm.controls;
  }

  resetForm() {
    console.log('Reset');
  }

  cancelFunction() {
    this.selectedAccount = null;
    console.log('Cancel');
  }

  onSubmit() {
    console.log('Submit');

    this.submitted = true;



    this.newPayment.employeeId = 0;
    this.newPayment.type = 'Pagamento';
    this.newPayment.userId = this.authenticationService.currentUser.id;
    this.newPayment.accountIban = this.selectedAccount.iban;
    this.newPayment.accountId = this.selectedAccount.id;
    this.newPayment.value = this.newPayment.value;

    this.totalValue = this.newPayment.value + (this.cents / 100);
    this.newPayment.value = this.totalValue;

    if ( this.paymentForm.invalid ) {
      return;
    }

    this.transactionService.addPayment(this.newPayment).pipe(first()).subscribe( response => {
      console.log(response);
    });

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
