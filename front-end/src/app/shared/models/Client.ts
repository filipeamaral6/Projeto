import { User } from './User';

export class Client extends User {

    fullName: string;
    nif: number;
    clientCC: number;
    birthDate: Date;
    phoneNumber?: number;
    mobileNumber?: number;
    address: string;
    zipCode: string;
    county: string;
    country: string;
    nationality: string;
    status: string;
    notification: string;
    transactionPassword?: string;
    createdAt?: string;

}
