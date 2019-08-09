export class Account {
  constructor(
    public balance: number,
    public id: number,
    public movementBalances: number[],
    public color: string) { }
}
