import { Injectable } from '@angular/core';
import { CurrentUser } from '../shared/models/CurrentUser';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})

export class AccessService {

  currentUser: CurrentUser;

  constructor(
    private authenticationService: AuthenticationService
  ) { }

  isLoggedIn() {

    if (!localStorage.getItem('currentUser')) {
      return false;
    }
    this.currentUser = this.authenticationService.currentUserValue;
    return true;

  }
}
