import { Transaction } from './Transaction';

export class Deposit extends Transaction {
    id?: number;
    employeeId?: number;
    transactionId?: number;
    depositerName?: string;
    depositerCcNumber?: number;
}
