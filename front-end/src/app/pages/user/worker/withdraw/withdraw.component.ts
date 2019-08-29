import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { Account } from 'app/shared/models/Account';
import { first } from 'rxjs/operators';
import { ClientService } from 'app/services/transport/client.service';
import { AccountService } from 'app/services/transport/account.service';
import { ModalEvent } from 'bootstrap';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Withdraw } from 'app/shared/models/Withdraw';
import { TransactionService } from 'app/services/transport/transaction.service';
import { AuthenticationService } from 'app/services/authentication.service';
import { EmployeeService } from 'app/services/transport/employee.service';
import { AlertService } from 'app/shared/alerts';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.css']
})
export class WithdrawComponent implements OnInit {
  statusArray = [
    'ALL',
    'ACTIVE',
    'INACTIVE'
  ];
  searchString: string;
  clients: Client[];
  accounts: Account[];
  selectedClient: Client;
  selectedAccount: Account;
  newWithdraw: Withdraw;

  constructor(private clientService: ClientService, private accountService: AccountService, private modalService: NgbModal,
    private transactionService: TransactionService, private authenticationService: AuthenticationService,
    private employeeService: EmployeeService, private alertService: AlertService) { }

  ngOnInit() {
    this.newWithdraw = new Withdraw();
    this.fetchClients('ALL');
  }

  doWithdraw() {
    this.employeeService.getAll().pipe(first()).subscribe(employees => {
      this.newWithdraw.accountId = this.selectedAccount.id;
      this.newWithdraw.accountIban = this.selectedAccount.iban;
      this.newWithdraw.userId = this.authenticationService.currentUser.id;
      this.newWithdraw.type = 'LEVANTAMENTO';
      this.newWithdraw.value = this.newWithdraw.value * -1;

      for (let employee of employees) {
        console.log(employee.userId + ' ' + this.authenticationService.currentUser.id);
        // tslint:disable-next-line: triple-equals
        if (employee.userId == this.authenticationService.currentUser.id) {
          this.newWithdraw.employeeId = employee.id;
          break;
        }
      }

      this.transactionService.addWithdraw(this.newWithdraw).pipe(first()).subscribe(response => {
        this.closeModal();
        this.alertService.success(JSON.parse(JSON.stringify(response)).message);
      }, error => {
        this.alertService.error(error.error.message);
      });
    });
  }

  openModal(content: ModalEvent, client: Client) {
    this.selectedClient = client;
    this.accountService.getAccountByClientId(client.id).pipe(first()).subscribe(accounts => {
      this.accounts = accounts;
      console.log(this.accounts);
      this.modalService.open(content, { size: 'lg', backdrop: 'static', keyboard: false });
    });
  }

  closeModal() {
    this.modalService.dismissAll();
    this.newWithdraw = new Withdraw();
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
