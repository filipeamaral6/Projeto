import { User } from 'app/shared/model/user.model';

export class Client extends User {

    fullName: string;
    nif: number;
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
    createdAt?: string;
    clientCC: number;

}
