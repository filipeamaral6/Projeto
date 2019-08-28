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
import { Transaction } from 'app/shared/models/Transaction';
import { TransactionService } from 'app/services/transport/transaction.service';
import { Payment } from 'app/shared/models/Payment';
import { Deposit } from 'app/shared/models/Deposit';
import { Transfer } from 'app/shared/models/Transfer';
import { Withdraw } from 'app/shared/models/Withdraw';

@Component({
  selector: 'app-accounts',
  templateUrl: './accounts.component.html',
  styleUrls: ['./accounts.css']
})
export class AccountsComponent implements OnInit {
  transaction: Transaction;
  payment: Payment;
  transfer: Transfer;
  withdraw: Withdraw;
  deposit: Deposit;
  statusArray: string[] = [
    'ALL',
    'ACTIVE',
    'INACTIVE'
  ];
  openTab: string;
  transactionList: Transaction[];
  filterTransaction: string;
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
    private alertService: AlertService, private employeeService: EmployeeService, private authenticationService: AuthenticationService,
    private transactionService: TransactionService) { }

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
    for (let elem of this.newHolders) {
      this.accountService.addClientToAccount(+elem.item_id, this.selectedAccount.id).pipe(first()).subscribe(response => {
        this.alertService.success(JSON.parse(JSON.stringify(response)).message);
        this.fetchAccountClients(this.selectedAccount.id);
      }, error => {
        this.alertService.error(error.error.message);
      });
    }
  }

  removeClientFromAccount(clientId: number, modal: ModalEvent, account: Account) {
    this.accountService.deleteClientFromAccount(clientId, this.selectedAccount.id).pipe(first()).subscribe(response => {
      this.alertService.success(JSON.parse(JSON.stringify(response)).message);
      this.fetchAccountClients(this.selectedAccount.id);
    }, error => {
      this.alertService.error(error.message);
    });
  }

  deactivateAccount() {
    this.selectedAccount.status = 'INACTIVE';
    this.selectedAccount.userId = this.authenticationService.currentUser.id;
    console.log(this.selectedAccount);
    this.accountService.updateAccount(this.selectedAccount).pipe(first()).subscribe(response => {
      this.closeModal();
      this.alertService.success('Conta desativada com sucesso!');
    }, error => {
      this.alertService.error(error);
    });
  }

  activateAccount() {
    this.selectedAccount.status = 'ACTIVE';
    this.selectedAccount.userId = this.authenticationService.currentUser.id;
    this.accountService.updateAccount(this.selectedAccount).pipe(first()).subscribe(response => {
      this.closeModal();
      this.alertService.success('Conta ativada com sucesso!');
    }, error => {
      this.alertService.error(error);
    });
  }

  openAccountDetailsModal(content: ModalEvent, account: Account) {
    this.newHolders = [];
    this.selectedAccount = account;
    this.fetchAccountClients(account.id);

    this.closeModal();
    this.modalService.open(content, { size: 'lg', backdrop: 'static', keyboard: false });
  }

  openAddAccountModal(content: ModalEvent) {
    this.newAccount = new Account();
    this.fetchClients();

    this.closeModal();
    this.modalService.open(content, { size: 'lg', backdrop: 'static', keyboard: false });
  }

  openTransactionDetailsModal(content: ModalEvent, transactionId: number) {
    this.transaction = null;
    this.payment = null;
    this.deposit = null;
    this.withdraw = null;
    this.transfer = null;

    this.getTransactionById(transactionId);
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

  fetchAccountClients(accountId: number) {
    this.accountService.getAccountClients(accountId).pipe(first()).subscribe(clients => {
      this.accountClients = clients;
    });
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
        console.log(accounts);
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

  fetchTransactions() {
    this.transactionService.getAllbyAccountIban(this.selectedAccount.iban).pipe(first()).subscribe(transactions => {
      console.log(transactions);
      this.transactionList = transactions;
      this.openTab = 'transactions';
      this.filterTransaction = null;
    }, error => {
      this.alertService.error(error.error.message);
    });
  }

  getTransactionById(id: number) {
    this.transactionService.getTransactionById(id).pipe(first()).subscribe(transaction => {
      console.log(transaction);
      this.transaction = transaction[0][0];
      let dateAux = transaction[0][0].createdAt.toString().split('T');
      this.transaction.date = dateAux[0];
      this.transaction.hour = dateAux[1].split('+')[0];
      if (transaction[0][0].type === 'PAGAMENTO') {
        this.payment = transaction[1][0];
      } else if (transaction[0][0].type === 'DEPÓSITO') {
        this.deposit = transaction[2][0];
      } else if (transaction[0][0].type === 'TRANSFERÊNCIA') {
        this.transfer = transaction[3][0];
      }
    });
  }

  isTransfer(transaction: Transaction) {
    const transfer: Transfer = transaction as Transfer;

    if(transfer.destinationIban) {
      console.log('true');
      return true;
    }

    console.log('false');
    return false;
  }

  closeModal() {
    this.openTab = '';
    this.editMode = false;
    this.editButtonLabel = 'Editar Dados';
    this.fetchClients();
  }
}
