import { Transaction } from './Transaction';

export class Deposit extends Transaction {

    employeeId: number;
    depositerName: string;
    depositerCCNumber: number;

}
