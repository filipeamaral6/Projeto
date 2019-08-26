import { Component } from '@angular/core';
import { CurrentUser } from './shared/models/CurrentUser';
import { User } from './shared/models/User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  currentUser: CurrentUser;
  userLocalStorage: string;


}
