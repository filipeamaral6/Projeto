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
import { TransactionService } from 'app/services/transport/transaction.service';
import { AuthenticationService } from 'app/services/authentication.service';
import { EmployeeService } from 'app/services/transport/employee.service';
import { Employee } from 'app/shared/models/Employee';

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

  constructor(private clientService: ClientService, private transactionService: TransactionService,
    private accountService: AccountService, private authenticationService: AuthenticationService,
    private alertService: AlertService, private employeeService: EmployeeService, config: NgbModalConfig,
    private modalService: NgbModal) { }

  ngOnInit() {
    this.clientService.getAll().pipe(first()).subscribe(clients => {
      this.clients = clients;
    });
  }

  depositIntoAccount(form: NgForm) {
    this.deposit.accountId = this.selectedAccount.id;
    this.deposit.accountIban = this.selectedAccount.iban;
    this.deposit.userId = this.selectedClient.userId;
    this.deposit.type = 'DEPOSIT';

    this.employeeService.getAll().pipe(first()).subscribe(employees => {
      for (let employee of employees) {
        console.log(employee.userId + ' ' + this.authenticationService.currentUser.id);
        // tslint:disable-next-line: triple-equals
        if (employee.userId == this.authenticationService.currentUser.id) {
          this.deposit.employeeId = employee.id;
          console.log(this.deposit);
          break;
        }
      }

      this.transactionService.addDeposit(this.deposit).pipe(first()).subscribe(response => {
        const message = JSON.parse(JSON.stringify(response)).message;

        this.modalService.dismissAll();
        this.alertService.success(message);
      }, error => {
        this.alertService.error(error.error.message);
      });
    });
  }

  openModal(content, client) {
    this.selectedClient = client;
    this.accountService.getAll().pipe(first()).subscribe(accounts => {
      this.accounts = accounts;
      console.log(this.accounts);
      this.modalService.open(content, { size: 'lg' });
      this.deposit = new Deposit();
    });
  }

  selectAccount(account: Account) {
    this.selectedAccount = account;
  }
}
