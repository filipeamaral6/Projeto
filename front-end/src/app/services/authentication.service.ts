import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';
import { CurrentUser } from '../shared/models/CurrentUser';
import { map } from 'rxjs/operators';
import { Globals } from '../shared/Globals';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'

  })
};

@Injectable({
  providedIn: 'root'
})

export class AuthenticationService {

  currentUser: CurrentUser;
  userLocalStorage: string;

  public get currentUserValue(): CurrentUser {
    return this.currentUser;
  }

  API = this.globals.API;

  constructor(
    private http: HttpClient,
    private globals: Globals) {
    this.persistUser();
  }

  login(username, password) {

    return this.http.post<any>(this.API + '/login', { username, password }, httpOptions)
      .pipe(map(response => {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(response));
        this.persistUser();
        return response;
      }));
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('currentUser');
    this.currentUser = null;
  }

  // recoverPassword(body: string) {
  //   return this.http.post(this.API + '/auth/recover-password', body);
  // }

  // resetPassword(body: string) {
  //   return this.http.post(this.API + '/auth/reset-password', body);
  // }

  persistUser() {
    this.userLocalStorage = localStorage.getItem('currentUser');
    this.currentUser = JSON.parse(this.userLocalStorage);
  }
}
