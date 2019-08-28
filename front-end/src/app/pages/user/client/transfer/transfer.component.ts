import { Component, OnInit } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AuthenticationService } from 'app/services/authentication.service';
import { TransactionService } from 'app/services/transport/transaction.service';
import { first } from 'rxjs/operators';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'transfer-cmp',
  moduleId: module.id,
  templateUrl: 'transfer.component.html',
  styleUrls: ['transfer.component.css']
})

export class TransferComponent implements OnInit {

  submitted = false;
  selectedAccount: Account;
  transferForm: FormGroup;
  isEyeOpen: boolean;

  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private transactionService: TransactionService,
  ) { }

  ngOnInit() {
    this.selectedAccount = null;

    this.initForm();
  }

  resetForm() {
    this.initForm();
  }

  cancelFunction() {
    this.selectAccount = null;
    this.initForm();
  }

  onSubmit() {
    console.log('Submit');
    this.submitted = true;

    this.transferForm.value.value = this.transferForm.value.euros + '.' + this.transferForm.value.cents;

    console.log( this.transferForm.value );

    // if ( this.transferForm.invalid ) {
    //   console.log(1);
    //   this.ngOnInit();
    //   return;
    // }

    this.transactionService.addTransfer(this.transferForm.value).pipe(first()).subscribe( response => {
      console.log(response);
    });
    this.submitted = false;
    this.cancelFunction()

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
    if ( account === null) {
      this.initForm();
    } else {
      this.transferForm.value.employeeId = 0;
      this.transferForm.value.type = 'TRANSFERÊNCIA';
      this.transferForm.value.userId = this.authenticationService.currentUser.id;
      this.transferForm.value.accountIban = this.selectedAccount.iban;
      this.transferForm.value.accountId = this.selectedAccount.id;
      console.log(this.transferForm);
    }
  }

  initForm() {

    this.isEyeOpen = false;

    this.transferForm = this.formBuilder.group({
      employeeId: [''],
      accountId: [''],
      userId: ['', Validators.required],
      type: ['', Validators.required],
      accountIban: ['', Validators.required],
      value: [''],
      euros: ['', Validators.required],
      cents: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
      description: ['', [Validators.required, Validators.maxLength(200)]],
      destinationIban: ['', [Validators.required, Validators.minLength(25), Validators.maxLength(25)]],
      transactionCode: ['', Validators.required]
    });
  }

}
