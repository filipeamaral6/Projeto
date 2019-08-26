
export class Account {

  id?: number
  type = 'CURRENT';
  iban = '';
  accountNumber = '';
  balance?: number;
  interest = 2.5;
  status = 'ACTIVE';
  createdAt?: Date;
  userId?: number;
  employeeId?: number;
  color?: string;
  movementBalances?: any[];
  holders?: any[];
}
