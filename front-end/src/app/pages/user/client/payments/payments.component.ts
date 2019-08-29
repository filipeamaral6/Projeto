import { Component, OnInit } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthenticationService } from 'app/services/authentication.service';
import { TransactionService } from 'app/services/transport/transaction.service';
import { first } from 'rxjs/operators';
import { AlertService } from 'app/shared/alerts/alert.service';
import { Payment } from 'app/shared/models/Payment';
import { Router } from '@angular/router';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'payments-cmp',
  moduleId: module.id,
  templateUrl: 'payments.component.html',
  styleUrls: ['payments.component.css']
})

export class PaymentsComponent implements OnInit {
  euros: number;
  cents: number;
  newPayment: Payment;
  selectedAccount: Account;
  paymentForm: FormGroup;
  isEyeOpen: boolean;
  submitted = false;


  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private transactionService: TransactionService,
    private alertService: AlertService,
    private router: Router
  ) { }

  ngOnInit() {
    this.selectedAccount = null;
    this.newPayment = new Payment();
    this.newPayment.employeeId = null;
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
    this.newPayment.value = +(this.euros + '.' + this.cents);
    this.newPayment.employeeId = null;

    console.log(this.newPayment);

    this.transactionService.addPayment(this.newPayment).pipe(first()).subscribe(response => {
      this.alertService.success(JSON.parse(JSON.stringify(response)).message + ' A redirecionar para os movimentos!');
      setTimeout(() => {
        this.router.navigate(['/client/movements/']);
      }, 3000);
    }, error => {
      console.log(error);
      this.alertService.error(error.error);
    });
    this.submitted = false;

  }

  digitOnly(event: { which: any; keyCode: any; }): boolean {
    const charCode = (event.which) ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
      return false;
    }
    return true;
  }

  showPass() {
    if (!this.isEyeOpen) {
      this.isEyeOpen = true;
    } else {
      this.isEyeOpen = false;
    }
  }

  selectAccount(account: Account) {
    this.isEyeOpen = false;
    this.selectedAccount = account;
    this.newPayment = new Payment();

    this.newPayment.type = 'PAGAMENTO';
    this.newPayment.userId = this.authenticationService.currentUser.id;
    this.newPayment.accountIban = this.selectedAccount.iban;
    this.newPayment.accountId = this.selectedAccount.id;
  }

}
