import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { AccountService } from 'app/services/transport/account.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Account } from 'app/shared/models/Account';
import { Transfer } from 'app/shared/models/Transfer';
import { TransactionService } from 'app/services/transport/transaction.service';
import { NgForm } from '@angular/forms';
import { EmployeeService } from 'app/services/transport/employee.service';
import { AuthenticationService } from 'app/services/authentication.service';
import { AlertService } from 'app/shared/alerts';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.css']
})
export class TransferComponent implements OnInit {
  searchString: string;
  statusArray = [
    'ALL',
    'ACTIVE',
    'INACTIVE'
  ];
  clients: Client[];
  selectedClient: Client;
  selectedAccount: Account;
  accounts: Account[];
  transfer: Transfer;

  constructor(private clientService: ClientService, private accountService: AccountService, private modalService: NgbModal,
    private transactionService: TransactionService, private employeeService: EmployeeService, private alertService: AlertService,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.fetchClients('ALL');
  }

  doTransfer() {
    this.employeeService.getAll().pipe(first()).subscribe(employees => {
      this.transfer.accountId = this.selectedAccount.id;
      this.transfer.accountIban = this.selectedAccount.iban;
      this.transfer.userId = this.selectedClient.userId;
      this.transfer.type = 'TRANSFERÊNCIA';

      for (let employee of employees) {
        console.log(employee.userId + ' ' + this.authenticationService.currentUser.id);
        // tslint:disable-next-line: triple-equals
        if (employee.userId == this.authenticationService.currentUser.id) {
          this.transfer.employeeId = employee.id;
          break;
        }
      }

      this.transactionService.addTransfer(this.transfer).pipe(first()).subscribe(response => {
        console.log(response);
        const message = JSON.parse(JSON.stringify(response)).message;

        this.modalService.dismissAll();
        this.alertService.success(message);
      }, error => {
        this.alertService.error(error.message);
      });
    });
  }

  openModal(content, client) {
    this.selectedClient = client;
    this.accountService.getAccountByClientId(client.id).pipe(first()).subscribe(accounts => {
      this.accounts = accounts;
      console.log(this.accounts);
      this.modalService.open(content, { size: 'lg' });
      this.transfer = new Transfer();
    });
  }

  fetchClients(value: string) {
    this.clients = [];
    if (value === 'ACTIVE') {
      this.clientService.getAll().pipe(first()).subscribe(clients => {
        clients.forEach(client => {
          if (client.status === 'ACTIVE') {
            this.clients.push(client);
          }
        });
      });
    } else if (value === 'INACTIVE') {
      this.clientService.getAll().pipe(first()).subscribe(clients => {
        clients.forEach(client => {
          if (client.status === 'INACTIVE') {
            this.clients.push(client);
          }
        });
      });
    } else {
      this.clientService.getAll().pipe(first()).subscribe(clients => {
        console.log(clients);
        this.clients = clients;
      });
    }
    console.log(this.clients);
  }
}
