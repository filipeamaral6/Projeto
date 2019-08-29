import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Globals } from 'app/shared/Globals';
import { Transaction } from 'app/shared/models/Transaction';
import { Deposit } from 'app/shared/models/Deposit';
import { Transfer } from 'app/shared/models/Transfer';
import { Payment } from 'app/shared/models/Payment';
import { Withdraw } from 'app/shared/models/Withdraw';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};

@Injectable({
    providedIn: 'root'
})

export class TransactionService {

    transfer: Transfer;

    API = this.globals.API;
    constructor(private http: HttpClient, private globals: Globals) { }

    getAllbyAccountIban(iban: string) {
        return this.http.get<any[]>(this.API + '/transaction/accountIBAN/' + iban);
    }

    getTransactionById(id: number) {

        return this.http.get<Transaction>(this.API + '/transaction/id/' + id);
    }

    getAll() {
        return this.http.get<Transaction[]>(this.API + '/transactions');
    }

    addDeposit(deposit: Deposit) {
        return this.http.post(this.API + '/deposit/add', deposit);
    }

    addTransfer(transfer: Transfer) {
        return this.http.post(this.API + '/transfer/add', transfer);
    }

    addPayment(payment: Payment) {
        return this.http.post(this.API + '/payment/add', payment);
    }

    addWithdraw(withdraw: Withdraw) {
        return this.http.post(this.API + '/withdraw/add', withdraw);
    }

    bindingPayment(info: any[], transaction: Transaction) {
        let payment: Payment = new Payment;
        payment.entity = info[0].entity;
        payment.reference = info[0].reference;
        payment.employeeId = info[0].employeeId;

        payment.id = transaction.id;
        payment.value = transaction.value;
        payment.accountIban = transaction.accountIban;
        payment.accountId = transaction.accountId;
        payment.createdAt = transaction.createdAt;
        payment.userId = transaction.userId;
        payment.type = transaction.type;
        payment.description = transaction.description;
        return payment;
    }
    bindingTransfer(info: any[], transaction: Transaction) {
        let transfer: Transfer = new Transfer;
        transfer.destinationIban = info[0].destinationIban;
        transfer.employeeId = info[0].employeeId;

        transfer.id = transaction.id;
        transfer.value = transaction.value;
        transfer.accountIban = transaction.accountIban;
        transfer.accountId = transaction.accountId;
        transfer.createdAt = transaction.createdAt;
        transfer.userId = transaction.userId;
        transfer.type = transaction.type;
        transfer.description = transaction.description;

        return transfer;
    }
    bindingDeposit(info: any[], transaction: Transaction) {
        let deposit: Deposit = new Deposit;
        deposit.employeeId = info[0].employeeId;
        deposit.depositerName = info[0].depositerName;
        deposit.depositerCcNumber = info[0].depositerCcNumber;

        deposit.id = transaction.id;
        deposit.value = transaction.value;
        deposit.accountIban = transaction.accountIban;
        deposit.accountId = transaction.accountId;
        deposit.createdAt = transaction.createdAt;
        deposit.userId = transaction.userId;
        deposit.type = transaction.type;
        deposit.description = transaction.description;
        return deposit;
    }
    bindingWithdraw(info: any[], transaction: Transaction) {
        let withdraw: Withdraw = new Withdraw;
        withdraw.employeeId = info[0].employeeId;

        withdraw.id = transaction.id;
        withdraw.value = transaction.value;
        withdraw.accountIban = transaction.accountIban;
        withdraw.accountId = transaction.accountId;
        withdraw.createdAt = transaction.createdAt;
        withdraw.userId = transaction.userId;
        withdraw.type = transaction.type;
        withdraw.description = transaction.description;
        return withdraw;
    }
}