import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Globals } from 'app/shared/Globals';
import { Deposit } from 'app/shared/models/Deposit';
import { Employee } from 'app/shared/models/Employee';
import { first } from 'rxjs/operators';

const httpOptions = {
    headers: new HttpHeaders({
        'Content-Type': 'application/json',
    })
};

@Injectable({
    providedIn: 'root'
})

export class EmployeeService {
    employee: Employee;

    API = this.globals.API;
    constructor(private http: HttpClient, private globals: Globals) { }

    getAll() {
        return this.http.get<Employee[]>(this.API + '/employees');
    }
}
