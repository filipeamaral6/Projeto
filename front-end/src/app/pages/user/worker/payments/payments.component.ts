import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { AccountService } from 'app/services/transport/account.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Account } from 'app/shared/models/Account';
import { TransactionService } from 'app/services/transport/transaction.service';
import { NgForm } from '@angular/forms';
import { EmployeeService } from 'app/services/transport/employee.service';
import { AuthenticationService } from 'app/services/authentication.service';
import { AlertService } from 'app/shared/alerts';
import { Payment } from 'app/shared/models/Payment';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.css']
})
export class PaymentsComponent implements OnInit {
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
  payment: Payment;

  constructor(private clientService: ClientService, private accountService: AccountService, private modalService: NgbModal,
    private transactionService: TransactionService, private employeeService: EmployeeService, private alertService: AlertService,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.fetchClients('All');
  }

  doPayment() {
    this.employeeService.getAll().pipe(first()).subscribe(employees => {
      this.payment.accountId = this.selectedAccount.id;
      this.payment.accountIban = this.selectedAccount.iban;
      this.payment.userId = this.selectedClient.userId;
      this.payment.type = 'PAGAMENTO';

      for (let employee of employees) {
        console.log(employee.userId + ' ' + this.authenticationService.currentUser.id);
        // tslint:disable-next-line: triple-equals
        if (employee.userId == this.authenticationService.currentUser.id) {
          this.payment.employeeId = employee.id;
          break;
        }
      }

      console.log(this.payment);
      this.transactionService.addPayment(this.payment).pipe(first()).subscribe(response => {
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
    this.accountService.getAccountByClientId(client.id).pipe(first()).subscribe(accounts => {
      this.accounts = accounts;
      console.log(this.accounts);
      this.modalService.open(content, { size: 'lg', backdrop: 'static', keyboard: false });
      this.payment = new Payment();
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
