import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Globals } from 'app/shared/Globals';
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

    addEmployee(employee: string) {
        return this.http.post(this.API + '/employees/add', employee, httpOptions);
    }

    updateEmployee(employee: string) {
        return this.http.put(this.API + '/employees/update', employee, httpOptions);
    }
}
