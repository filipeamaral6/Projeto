import { User } from './User';

export class Client extends User {

    address?: string;
    birthDate?: string;
    clientCc?: string;
    country?: string;
    county?: string;
    createdAt?: string;
    //email?: string;
    fullName?: string;
    id?: number;
    loginPassword?: string;
    mobileNumber?: string;
    nationality?: string;
    nif?: string;
    notification = 'TRUE';
    phoneNumber?: string;
    //role = 'CLIENT';
    //status = 'ACTIVE';
    transactionPassword?: string;
    //userId?: number;
    //username?: string;
    zipCode?: string;
}
