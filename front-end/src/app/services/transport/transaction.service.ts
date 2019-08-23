import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Globals } from 'app/shared/Globals';
import { Transaction } from 'app/shared/models/Transaction';
import { Deposit } from 'app/shared/models/Deposit';
import { Transfer } from 'app/shared/models/Transfer';
import { Payment } from 'app/shared/models/Payment';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};

@Injectable({
    providedIn: 'root'
})

export class TransactionService {

    API = this.globals.API;
    constructor(private http: HttpClient, private globals: Globals) { }

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
}
