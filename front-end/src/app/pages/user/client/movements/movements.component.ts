
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

  constructor(
    private transactionService: TransactionService,
    private authenticationService: AuthenticationService,
    private accontService: AccountService,
    private modalService: NgbModal,
    ) {}

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
    this.transactionService.getAllbyAccountIban(this.selectedAccount.iban).pipe(first()).subscribe( transactions => {
      transactions.forEach(transaction => {
        transaction.createdAt = transaction.createdAt.substring(0, 10);
        this.transactionList.push(transaction);
      });
    });
  }

  getClientAllTransactions() {
    this.transactionList = [];
    this.accontService.getAccountByClientId(this.authenticationService.currentUser.id).pipe(first()).subscribe( accounts => {
      accounts.forEach(account => {
        this.transactionService.getAllbyAccountIban(account.iban).pipe(first()).subscribe( transactions => {
          transactions.forEach(transaction => {

            let dateAux = transaction.createdAt.split('+');
            dateAux = dateAux[0].split('T');
            transaction.date = dateAux[0];
            transaction.hour = dateAux[1];

            this.transactionService.getTransactionById(transaction.id).pipe(first()).subscribe( array => {
              if ( transaction.type === 'Pagamento' ) {
                this.paymentList.push(this.transactionService.bindingPayment(array[1], transaction));
              }
              if ( transaction.type === 'Transferência' ) {
                this.transferList.push(this.transactionService.bindingTransfer(array[3], transaction));
              }
              if ( transaction.type === 'Depósito' ) {
                this.depositList.push(this.transactionService.bindingDeposit(array[2], transaction));
              }
              if ( transaction.type === 'Levantamento' ) {
                this.withdrawList.push(this.transactionService.bindingWithdraw(array[4], transaction));
              }
            });

            this.transactionList.push(transaction);
          });
        });
      });
    });
  }

  openModal(content: any, transaction: Transaction) {
    this.selectedTransaction = this.selectTransaction( transaction );
    console.log(this.selectTransaction(transaction));

    this.modalService.open(content, { size: 'lg' });
  }

  selectTransaction( transaction: Transaction) {
    if (transaction.type === 'Pagamento') {
      this.paymentList.forEach(payment => {

        if ( payment.id === transaction.id ) {
          return payment;
        }
      });
    }
    if (transaction.type === 'Levantamento') {
      this.withdrawList.forEach(withdraw => {
        console.log(withdraw);
        if (withdraw.id === transaction.id ) {
          return withdraw;
        }
      });
    }
    if (transaction.type === 'Transferência') {
      this.transferList.forEach(transfer => {
        console.log(transfer);
        if ( transfer.id === transaction.id ) {
          return transfer;
        }
      });
    }
    if (transaction.type === 'Depósito') {
      this.depositList.forEach(deposit => {
        console.log(deposit);
        if ( deposit.id === transaction.id ) {
          return deposit;
        }
      });
    }
    return null;
  }

}
