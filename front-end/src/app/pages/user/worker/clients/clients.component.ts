import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from 'app/services/authentication.service';
import { AlertService } from 'app/shared/alerts';
import { Account } from 'app/shared/models/Account';
import { AccountService } from 'app/services/transport/account.service';
import { EmployeeService } from 'app/services/transport/employee.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.css']
})
export class ClientsComponent implements OnInit {
  clients: Client[];
  selectedClient: Client;
  newClient: Client;
  newAccount: Account;
  verifyPassword: string;
  editMode = false;
  role: string;
  editButtonLabel = 'Editar Dados';
  nationalities: string[] = [
    'Albanesa',
    'Alemã',
    'Austríaca',
    'Belga',
    'Búlgara',
    'Croata',
    'Cipriota',
    'Dinamarquesa',
    'Eslovaca',
    'Eslovena',
    'Espanhola',
    'Francesa',
    'Finlandesa',
    'Grega',
    'Húngara',
    'Islandesa',
    'Irlandesa',
    'Italiana',
    'Kosovar',
    'Lituana',
    'Luxemburguesa',
    'Montenegrina',
    'Holandesa',
    'Norueguesa',
    'Polaca',
    'Portuguesa',
    'Inglesa',
    'Romena',
    'Russa',
    'Suecas',
    'Suíça',
    'Turca',
    'Ucraniana'
  ];

  constructor(private authenticationService: AuthenticationService, private clientService: ClientService,
    private accountService: AccountService, config: NgbModalConfig, private modalService: NgbModal,
    private alertService: AlertService, private employeeService: EmployeeService) { }

  ngOnInit() {
    this.fetchClients();
    this.role = this.authenticationService.currentUser.role;
  }

  fetchClients() {
    this.clientService.getAll().pipe(first()).subscribe(clients => {
      console.log(clients);
      this.clients = clients;
    });
  }

  addClient(form: NgForm) {

    const newClientString = JSON.stringify(this.newClient);

    this.clientService.addClient(newClientString).pipe(first()).subscribe(response => {
      console.log(response);

      this.employeeService.getAll().pipe(first()).subscribe(employees => {
        for (let employee of employees) {
          // tslint:disable-next-line: triple-equals
          if (employee.userId == this.authenticationService.currentUser.id) {
            this.newAccount.employeeId = employee.id;
            break;
          }
        }

        this.clientService.getByClientCC(this.newClient.clientCc).pipe(first()).subscribe(client => {
          this.newAccount.userId = client[0].userId;

          this.accountService.addAccount(JSON.stringify(this.newAccount)).pipe(first()).subscribe(responseAccount => {
            this.modalService.dismissAll();
            const message = JSON.parse(JSON.stringify(response)).message;
            this.alertService.success(JSON.stringify(message));
            this.fetchClients();
          }, error => {
            this.showErrorAlert(error);
          }
          );
        });
      }, error => {
        this.showErrorAlert(error);
      });
    }, error => {
      this.showErrorAlert(error);
    });
  }

  updateClient(form: NgForm) {

    const updatedClient = JSON.stringify(this.selectedClient);

    this.clientService.updateClient(updatedClient).pipe(first()).subscribe(response => {
      console.log(response);
      this.fetchClients();
      this.modalService.dismissAll();

      const message = JSON.parse(JSON.stringify(response)).message;
      this.alertService.success(message);
    }, error => {
      this.showErrorAlert(error);
    });
  }

  deactivateClient(id: number) {
    this.selectedClient.status = 'INACTIVE';

    const updatedClient = JSON.stringify(this.selectedClient);

    this.clientService.updateClient(updatedClient).pipe(first()).subscribe(response => {
      console.log(response);
      this.modalService.dismissAll();
    });
  }

  activateClient(id: number) {
    this.selectedClient.status = 'ACTIVE';

    const updatedClient = JSON.stringify(this.selectedClient);

    this.clientService.updateClient(updatedClient).pipe(first()).subscribe(response => {
      console.log(response);
      this.modalService.dismissAll();
    });
  }

  openModal(content, client) {
    if (client !== null) {
      this.selectedClient = client;
      const formattedDate: string[] = this.selectedClient.birthDate.split('T');
      if (formattedDate.length > 0) {
        this.selectedClient.birthDate = formattedDate[0];
      }
    } else {
      this.newClient = new Client();
      this.newAccount = new Account();
    }
    this.modalService.open(content, { size: 'lg' });
  }

  toggleEditMode() {
    this.editMode = !this.editMode;

    if (this.editMode) {
      this.editButtonLabel = 'Cancelar Edição';
    } else {
      this.editButtonLabel = 'Editar Dados';

      this.modalService.dismissAll();

      this.fetchClients();
    }
  }

  generatePassword(controlName: string) {
    if (controlName === 'password') {
      this.newClient.loginPassword = this.randomString('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', 15);
    } else {
      this.newClient.transactionPassword = this.randomString('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789', 15);
    }
  }

  // generateIban() {
  //   let iban = 'PT50';
  //   iban += this.randomString('0123456789', 21);

  //   this.newAccount.iban = iban;
  // }

  // generateAccountNumber() {
  //   let accountNumber = this.randomString('0123456789', 11);

  //   this.newAccount.accountNumber = accountNumber;
  // }

  private randomString(characters: string, length: number) {
    let result = '';
    const charactersLength = characters.length;
    for (let i = 0; i < length; i++) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }

    return result;
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
      case 'birthDate':
        return 'Data de Nascimento';
      case 'nationality':
        return 'Nacionalidade';
      case 'clientCc':
        return 'Número de C.C.';
      case 'nif':
        return 'NIF';
      case 'email':
        return 'Email';
      case 'phoneNumber':
        return 'Telefone';
      case 'mobileNumber':
        return 'Telemóvel';
      case 'address':
        return 'Morada';
      case 'zipCode':
        return 'Código Postal';
      case 'county':
        return 'Localidade';
      case 'country':
        return 'País';
      case 'username':
        return 'Username';
      case 'loginPassword':
        return 'Password';
      case 'transactionPassword':
        return 'Password para transações'
    }
  }
}
