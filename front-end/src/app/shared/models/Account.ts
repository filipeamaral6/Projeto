
export class Account {

  id?: number
  type: string;
  iban?: string;
  accountNumber?: number;
  balance: number;
  interest: number;
  status: string;
  createdAt?: Date;
  employeeId: number;
  color?: string;
  movementBalances?: any[];
}
