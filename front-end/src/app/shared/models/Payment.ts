import { Transaction } from './Transaction';

export class Payment extends Transaction {

    entity: number;
    reference: number;
    employeeId: number;
}
