import { Component } from '@angular/core';
import { User } from './shared/model/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  user: User = {
    fullName: 'Zé Mário',
    email: 'ze_mario@gmail.com',
    username: 'ze.mario',
    nationality: 'portuguesa',
    nif: '123456789',
    phoneNumber: '216531548',
    mobileNumber: '923154687',
    address: 'Rua do Zé Mário, 12, 1ºEsq',
    zipCode: '2935-215',
    county: 'Aldeia do Zé',
    country: 'Portugal',
    accounts: [
      {
        id: 1,
        balance: 123456,
        movementBalances: [10, 50, 200, 150, 1000, 2000, 123456]
      },
      {
        id: 2,
        balance: 654321,
        movementBalances: [100, 400, 450, 460, 500, 200, 300, 654321]
      }
    ]
  };

}
