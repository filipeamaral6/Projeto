import { Component, OnInit } from '@angular/core';
import { Employee } from 'app/shared/models/Employee';
import { EmployeeService } from 'app/services/transport/employee.service';
import { first } from 'rxjs/operators';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
import { AlertService } from 'app/shared/alerts';
import { AuthenticationService } from 'app/services/authentication.service';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

  employees: Employee[];
  selectedEmployee: Employee;
  newEmployee: Employee;
  editMode = false;
  searchString: string;
  editButtonLabel = 'Editar Dados';
  roles: string[] = [
    'EMPLOYEE',
    'ADMIN'
  ]
  statusArray: string[] = [
    'ALL',
    'ACTIVE',
    'INACTIVE'
  ]

  constructor(private employeeService: EmployeeService,
    private modalService: NgbModal,
    private alertService: AlertService,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
    this.fetchEmployees('ALL');
  }

  addEmployee(form: NgForm) {

    const newEmployeeString = JSON.stringify(this.newEmployee);
    console.log(this.newEmployee);
    this.employeeService.addEmployee(newEmployeeString).pipe(first()).subscribe(response => {
      console.log(response);
      this.modalService.dismissAll();
      const message = JSON.parse(JSON.stringify(response)).message;
      this.alertService.success(message);
      this.fetchEmployees('ALL');
    },
      error => {
        this.showErrorAlert(error);
      });
  }

  fetchEmployees(value: string) {
    this.employees = [];
    if (value === 'ACTIVE') {
      this.employeeService.getAll().pipe(first()).subscribe(employees => {
        employees.forEach(employee => {
          if (employee.status === 'ACTIVE') {
            this.employees.push(employee);
          }
        });
      });
    } else if (value === 'INACTIVE') {
      this.employeeService.getAll().pipe(first()).subscribe(employees => {
        employees.forEach(employee => {
          if (employee.status === 'INACTIVE') {
            this.employees.push(employee);
          }
        });
      });
    } else {
      this.employeeService.getAll().pipe(first()).subscribe(employees => {
        this.employees = employees;
      });
    }
    console.log(this.employees);
  }

  updateEmployee(form: NgForm) {

    const updatedEmployee = JSON.stringify(this.selectedEmployee);

    this.employeeService.updateEmployee(updatedEmployee).pipe(first()).subscribe(response => {
      console.log(response);
      this.fetchEmployees('ALL');
      this.modalService.dismissAll();

      const message = JSON.parse(JSON.stringify(response)).message;
      this.alertService.success(message);
      this.closeModal();
    }, error => {
      this.showErrorAlert(error);
    });
  }

  deactivateEmployee(id: number) {
    this.selectedEmployee.status = 'INACTIVE';

    const updatedEmployee = JSON.stringify(this.selectedEmployee);

    this.employeeService.updateEmployee(updatedEmployee).pipe(first()).subscribe(response => {
      console.log(response);
      this.modalService.dismissAll();
      this.closeModal();
    });
  }

  activateEmployee(id: number) {
    this.selectedEmployee.status = 'ACTIVE';

    const updatedEmployee = JSON.stringify(this.selectedEmployee);

    this.employeeService.updateEmployee(updatedEmployee).pipe(first()).subscribe(response => {
      console.log(response);
      this.modalService.dismissAll();
      this.closeModal();
    });
  }

  generatePassword() {
    this.newEmployee.password = this.randomString('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', 15);
  }

  private randomString(characters: string, length: number) {
    let result = '';
    const charactersLength = characters.length;
    for (let i = 0; i < length; i++) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
  }

  closeModal() {
    this.editMode = false;
    this.editButtonLabel = 'Editar Dados';
    this.fetchEmployees('ALL');
  }

  toggleEditMode() {
    this.editMode = !this.editMode;

    if (this.editMode) {
      this.editButtonLabel = 'Cancelar Edição';
    } else {
      this.editButtonLabel = 'Editar Dados';

      this.modalService.dismissAll();

      this.fetchEmployees('ALL');
    }
  }

  openModal(content, employee) {
    if (employee !== null) {
      this.selectedEmployee = employee;
    } else {
      this.newEmployee = new Employee();
    }
    this.modalService.open(content, { size: 'lg', backdrop: 'static', keyboard: false });
  }

  private showErrorAlert(error: ErrorEvent) {
    let message: string;
    if (error.error.field) {
      message = 'Campo "' + this.translateField(error.error.field) + '" por preencher!';
    } else {
      message = error.error.message;
    }
    this.alertService.error(message);
  }

  private translateField(field: string) {
    switch (field) {
      case 'fullName':
        return 'Nome Completo';
      case 'email':
        return 'Email';
      case 'username':
        return 'Username';
      case 'loginPassword':
        return 'Password';
    }
  }
}
