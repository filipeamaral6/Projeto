import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Client } from 'app/shared/models/Client';
import { Observable } from 'rxjs';
import { Globals } from 'app/shared/Globals';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  })
};

@Injectable({
  providedIn: 'root'
})

export class ClientService {

  API = this.globals.API;
  constructor(private http: HttpClient, private globals: Globals) { }

  getAll() {
    return this.http.get<Client[]>(this.API + '/clients');
  }

  getById(id: number) {
    return this.http.get<Client>(this.API + '/clients/id/' + id);
  }

  getByClientCC(clientCC: number) {
    return this.http.get<Client>(this.API + '/clients/cc/' + clientCC);
  }

  addClient(client: string) {
    return this.http.post(this.API + '/clients/add', client, httpOptions);
  }

  updateClient(client: string) {
    return this.http.put(this.API + '/clients/update', client, httpOptions);
  }
}
