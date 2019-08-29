import { Component, OnInit } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { AuthenticationService } from 'app/services/authentication.service';
import { TransactionService } from 'app/services/transport/transaction.service';
import { first } from 'rxjs/operators';
import { Transfer } from 'app/shared/models/Transfer';
import { CurrentUser } from 'app/shared/models/CurrentUser';
import { AlertService } from 'app/shared/alerts';
import { Router } from '@angular/router';

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
  currentUser: CurrentUser;
  accountList: Account[];

  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private transactionService: TransactionService,
    private alertService: AlertService,
    private route: Router
  ) {
    this.currentUser = this.authenticationService.currentUserValue;
  }

  get f() {
    return this.transferForm.controls;
  }

  ngOnInit() {
    this.selectedAccount = null;
    this.isEyeOpen = false;

    this.transferForm = this.formBuilder.group({
      type: ['TRANSFERÊNCIA', Validators.required],
      destinationIban: ['', Validators.required],
      euros: ['', Validators.required],
      cents: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
      description: ['', [Validators.required, Validators.maxLength(200)]],
      transactionCode: ['', Validators.required]
    });
  }

  resetForm() {
    this.transferForm.reset();
  }


  onSubmit() {
    this.submitted = true;

    let value = this.transferForm.value.euros + '.' + this.transferForm.value.cents;

    let transfer = new Transfer();
    transfer.accountId = this.selectedAccount.id;
    transfer.accountIban = this.selectedAccount.iban;
    transfer.description = this.transferForm.value.description;
    transfer.destinationIban = this.transferForm.value.destinationIban;
    transfer.type = this.transferForm.value.type;
    transfer.value = +value * -1;
    transfer.userId = this.currentUser.id;

    console.log(this.transferForm);

    if (this.transferForm.invalid) {
      return;
    }

    this.transactionService.addTransfer(transfer).pipe(first()).subscribe(
      response => {
        this.alertService.success('Transferência concluída com sucesso');
        this.ngOnInit();
        setTimeout(() => { this.route.navigate(['/client/movements']); }, 1500);
      },
      error => {
        this.showErrorAlert(error);
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
    if (!this.isEyeOpen) {
      this.isEyeOpen = true;
    } else {
      this.isEyeOpen = false;
    }
  }

  selectAccount(account: Account) {
    this.selectedAccount = account;
    this.transferForm.value.employeeId = 0;
    this.transferForm.value.type = 'TRANSFERÊNCIA';
    this.transferForm.value.userId = this.authenticationService.currentUser.id;
    this.transferForm.value.accountIban = this.selectedAccount.iban;
    this.transferForm.value.accountId = this.selectedAccount.id;
    console.log(this.transferForm);
  }

  private showErrorAlert(error: ErrorEvent) {
    let message: string;
    if (error.error.field) {
      message = 'Erro no campo "' + this.translateField(error.error.field) + '": ' + error.error.message;
    } else {
      message = error.error.message;
    }
    this.alertService.error(message);
  }

  private translateField(field: string) {
    switch (field) {
      case 'value':
        return 'Valor';
      case 'accountIban':
        return 'IBAN de origem';
      case 'description':
        return 'Descrição';
      case 'destinationIban':
        return 'IBAN de destino';
    }
  }
}
