export class User {
  constructor(
    public fullName: string,
    public email: string,
    public username: string,
    public admin?: string,
    public nif?: string,
    public phoneNumber?: string,
    public mobileNumber?: string,
    public address?: string,
    public zipCode?: string,
    public county?: string,
    public country?: string,
    public nationality?: string,
    public status?: string,
    public notification?: string,
    public createdAt?: string,
    public accounts?: any[]
    ) {}
}
