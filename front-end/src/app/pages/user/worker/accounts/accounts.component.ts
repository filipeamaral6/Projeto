import { Component, OnInit } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AccountService } from 'app/services/transport/account.service';
import { first } from 'rxjs/operators';
import { Client } from 'app/shared/models/Client';
import { ModalEvent } from 'bootstrap';
import { ClientService } from 'app/services/transport/client.service';
import { AlertService } from 'app/shared/alerts';
import { EmployeeService } from 'app/services/transport/employee.service';
import { AuthenticationService } from 'app/services/authentication.service';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.css']
})
export class AccountsComponent implements OnInit {
  statusArray: string[] = [
    'ALL',
    'ACTIVE',
    'INACTIVE'
  ];
  searchString: string;
  accounts: Account[];
  clients: Client[];
  selectedAccount: Account;
  newAccount: Account;
  newHolders: any[];
  editMode: boolean;
  editButtonLabel: string;
  accountClients: Client[];
  dropdownList = [];
  dropdownSettings = {};

  constructor(private modalService: NgbModal, private accountService: AccountService, private clientService: ClientService,
    private alertService: AlertService, private employeeService: EmployeeService, private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.editMode = false;
    this.editButtonLabel = 'Editar Titulares';
    this.accountService.getAll().pipe(first()).subscribe(accounts => {
      this.accounts = accounts;
    });
    this.fetchClients();
    this.dropdownSettings = {
      idField: 'item_id',
      textField: 'item_text',
      singleSelection: false,
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 6,
      allowSearchFilter: true
    };
  }

  addAccount() {
    this.newAccount.userId = this.newAccount.holders.reverse().pop().item_id;
    console.log(this.newAccount);

    this.employeeService.getAll().pipe(first()).subscribe(employees => {
      for (let employee of employees) {
        // tslint:disable-next-line: triple-equals
        if (employee.userId == this.authenticationService.currentUser.id) {
          this.newAccount.employeeId = employee.id;
          break;
        }
      }

      this.accountService.addAccount(JSON.stringify(this.newAccount)).pipe(first()).subscribe(addResponse => {
        this.accountService.getAll().pipe(first()).subscribe(accounts => {
          const addedAccount = accounts[accounts.length - 1];
          for (let holder of this.newAccount.holders) {
            this.accountService.addClientToAccount(holder.item_id, addedAccount.id).pipe(first()).subscribe(response => {
            });
          }
        });
      }, error => {
        this.alertService.error(error);
      });
    });
  }

  updateAccount() {
    for(let client of this.newHolders) {
      this.accountService.addClientToAccount(+client.item_id, this.selectedAccount.id).pipe(first()).subscribe(response => {
        this.alertService.success(JSON.parse(JSON.stringify(response)).message);
      });
    }
  }

  removeClientFromAccount(clientId: number, modal: ModalEvent, account: Account) {
    this.accountService.deleteClientFromAccount(clientId, this.selectedAccount.id).pipe(first()).subscribe(response => {
      this.alertService.success(JSON.parse(JSON.stringify(response)).message);
      for (let client of this.accountClients) {
        // tslint:disable-next-line: triple-equals
        if (client.id == clientId) {
          this.accountClients.splice(this.accountClients.indexOf(client), 1);
          break;
        }
      }
    }, error => {
      this.alertService.error(error.message);
    });
  }

  deactivateAccount() {
    this.selectedAccount.status = 'INACTIVE';
    this.accountService.updateAccount(this.selectedAccount).pipe(first()).subscribe(response => {
      this.closeModal();
      this.alertService.success('Conta desativada com sucesso!');
    }, error => {
      this.alertService.error(error.message);
    });
  }

  activateAccount() {
    this.selectedAccount.status = 'ACTIVE';
    this.accountService.updateAccount(this.selectedAccount).pipe(first()).subscribe(response => {
      this.closeModal();
      this.alertService.success('Conta ativada com sucesso!');
    }, error => {
      this.alertService.error(error.message);
    });
  }

  openAccountDetailsModal(content: ModalEvent, account: Account) {
    this.selectedAccount = account;
    this.accountService.getAccountClients(account.id).pipe(first()).subscribe(clients => {
      this.accountClients = clients;
      console.log(this.accountClients);
    });

    this.closeModal();
    this.modalService.open(content, { size: 'lg', backdrop: 'static', keyboard: false });
  }

  openAddAccountModal(content: ModalEvent) {
    this.newAccount = new Account();
    this.fetchClients();

    this.closeModal();
    this.modalService.open(content, { size: 'lg', backdrop: 'static', keyboard: false });
  }

  toggleEditMode() {
    this.editMode = !this.editMode;

    if (this.editMode) {
      this.editButtonLabel = 'Cancelar Edição';
      this.fetchClients();
    }
    else {
      this.editButtonLabel = 'Editar Titulares';
      this.clients = [];
    }
  }

  fetchAccounts(value: string) {
    this.accounts = [];
    if (value === 'ACTIVE') {
      this.accountService.getAll().pipe(first()).subscribe(accounts => {
        accounts.forEach(account => {
          if (account.status === 'ACTIVE') {
            this.accounts.push(account);
          }
        });
      });
    } else if (value === 'INACTIVE') {
      this.accountService.getAll().pipe(first()).subscribe(accounts => {
        accounts.forEach(account => {
          if (account.status === 'INACTIVE') {
            this.accounts.push(account);
          }
        });
      });
    } else {
      this.accountService.getAll().pipe(first()).subscribe(accounts => {
        this.accounts = accounts;
      });
    }
    console.log(this.accounts);
  }

  fetchClients() {
    this.clientService.getAll().pipe(first()).subscribe(clients => {
      this.clients = clients;
      for (let client of clients) {
        this.dropdownList.push({ item_id: client.userId, item_text: client.email });
      }
    });
  }

  closeModal() {
    this.editMode = false;
    this.editButtonLabel = 'Editar Dados';
    this.fetchClients();
  }
}
