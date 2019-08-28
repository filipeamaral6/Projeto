
import { Component, OnInit } from '@angular/core';
import { Account } from 'app/shared/models/Account';
import { TransactionService } from 'app/services/transport/transaction.service';
import { first } from 'rxjs/operators';
import { Transfer } from 'app/shared/models/Transfer';
import { Deposit } from 'app/shared/models/Deposit';
import { Payment } from 'app/shared/models/Payment';
import { Transaction } from 'app/shared/models/Transaction';
import { AuthenticationService } from 'app/services/authentication.service';
import { AccountService } from 'app/services/transport/account.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Withdraw } from 'app/shared/models/Withdraw';
import { AlertService } from 'app/shared/alerts/alert.service';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'movements-cmp',
  moduleId: module.id,
  templateUrl: 'movements.component.html',
  styleUrls: ['movements.component.css']
})

export class MovementsComponent implements OnInit {
  selectedAccount: Account;
  selectedTransaction: any;
  withdrawList: Withdraw[];
  depositList: Deposit[];
  transferList: Transfer[];
  paymentList: Payment[];
  transactionList: Transaction[];
  filterTransaction: string;
  transaction: Transaction;
  payment: Payment;
  deposit: Deposit;
  transfer: Transfer;
  withdraw: Withdraw;

  constructor(
    private transactionService: TransactionService,
    private authenticationService: AuthenticationService,
    private accontService: AccountService,
    private modalService: NgbModal,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.filterTransaction = null;
    this.getClientAllTransactions();
    this.selectedAccount = null;
    this.depositList = [];
    this.transferList = [];
    this.paymentList = [];
    this.withdrawList = [];
  }

  selectAccount(account: Account) {
    this.transactionList = [];
    this.selectedAccount = account;
    this.transactionService.getAllbyAccountIban(this.selectedAccount.iban).pipe(first()).subscribe(transactions => {
      transactions.forEach(transaction => {
        transaction.createdAt = transaction.createdAt.substring(0, 10);
        this.transactionList.push(transaction);
      });
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

  getClientAllTransactions() {
    this.transactionList = [];
    this.accontService.getAccountByClientId(this.authenticationService.currentUser.id).pipe(first()).subscribe(accounts => {
      accounts.forEach(account => {
        this.transactionService.getAllbyAccountIban(account.iban).pipe(first()).subscribe(transactions => {
          console.log(transactions)
          this.transactionList = transactions;
        });
      });
    }, error => {
      this.alertService.error(error);
    });
  }

  openModal(content: any, transaction: Transaction) {
    this.getTransactionById(transaction.id);
    console.log(transaction);
    this.modalService.open(content, { size: 'lg' });
  }

  closeModal() {
    this.transaction = null;
    this.deposit = null;
    this.payment = null;
    this.transfer = null;
    this.withdraw = null;
  }
}
