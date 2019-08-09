import { Transaction } from './Transaction';

export class Transfer extends Transaction {

    destinationIban: string;
    employeeId: number;

}
