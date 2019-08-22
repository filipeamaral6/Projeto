import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { AccountService } from 'app/services/transport/account.service';
import { Account } from 'app/shared/models/Account';
import { Deposit } from 'app/shared/models/Deposit';
import { NgForm } from '@angular/forms';
import { AlertService } from 'app/shared/alerts';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.css']
})
export class DepositComponent implements OnInit {
  clients: Client[];
  accounts: Account[];
  selectedClient: Client;
  selectedAccount: Account;
  deposit: Deposit;

  constructor(private clientService: ClientService, private accountService: AccountService, private alertService: AlertService,
    config: NgbModalConfig, private modalService: NgbModal) { }

  ngOnInit() {
    this.clientService.getAll().pipe(first()).subscribe(clients => {
      this.clients = clients;
    });
  }

  depositIntoAccount(form: NgForm){
    this.selectedAccount.balance += this.deposit.amount;
    const updatedAccount = JSON.stringify(this.selectedAccount);

    this.accountService.updateAccount(updatedAccount).pipe(first()).subscribe(response => {
      this.alertService.success(JSON.stringify(response.message));
    });
  }

  openModal(content, client) {
    this.selectedClient = client;
    this.accountService.getAll().pipe(first()).subscribe(accounts => {
      this.accounts = accounts;
      console.log(this.accounts);
      this.modalService.open(content, { size: 'xl' });
      this.deposit = new Deposit();
    });
  }

  selectAccount(account: Account) {
    this.selectedAccount = account;
  }
}
