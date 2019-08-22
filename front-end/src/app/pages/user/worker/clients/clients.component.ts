import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
<<<<<<< HEAD
import { AuthenticationService } from 'app/services/authentication.service';
import { AlertService } from 'app/shared/alerts';
=======

//adicionar a data correta ao modal
>>>>>>> André

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.css']
})
export class ClientsComponent implements OnInit {
  clients: Client[];
  selectedClient: Client;
<<<<<<< HEAD
  newClient: Client;
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
    config: NgbModalConfig, private modalService: NgbModal, private alertService: AlertService) { }

  ngOnInit() {
    this.fetchClients();
    this.role = this.authenticationService.currentUser.role;
=======
  clientToEdit: Client;
  editMode = false;
  editButtonLabel = 'Editar Dados';

  constructor(private clientService: ClientService, config: NgbModalConfig, private modalService: NgbModal) { }

  ngOnInit() {
    this.fetchClients();
>>>>>>> André
  }

  fetchClients() {
    this.clientService.getAll().pipe(first()).subscribe(clients => {
      this.clients = clients;
    });
  }

<<<<<<< HEAD
  addClient(form: NgForm) {
    // const newClient: Client = {
    //   address: form.value.address,
    //   birthDate: form.value.birthDate,
    //   clientCc: form.value.clientCc,
    //   country: form.value.country,
    //   county: form.value.county,
    //   email: form.value.email,
    //   fullName: form.value.fullName,
    //   loginPassword: form.value.loginPassword,
    //   mobileNumber: form.value.mobileNumber,
    //   nationality: form.value.nationality,
    //   nif: form.value.nif,
    //   notification: true, // string or boolean in backend?
    //   phoneNumber: form.value.phoneNumber,
    //   role: 'CLIENT',
    //   status: 'ACTIVE',
    //   transactionPassword: form.value.transactionPassword,
    //   username: form.value.username,
    //   zipCode: form.value.zipCode
    // }

    console.log(form);

    const newClientString = JSON.stringify(this.newClient);

    this.clientService.addClient(newClientString).pipe(first()).subscribe(response => {
      console.log(response);
      this.alertService.success('Cliente adicionado com sucesso!');
    }, error => {
      this.alertService.error(JSON.stringify(error));
    });
  }

  updateClient(form: NgForm) {
    console.log(form);
=======
  updateClient(form: NgForm) {
>>>>>>> André
    this.selectedClient.fullName = form.value.fullName;
    this.selectedClient.birthDate = form.value.birthDate;
    this.selectedClient.nationality = form.value.nationality;
    this.selectedClient.clientCc = form.value.clientCc;
    this.selectedClient.nif = form.value.nif;
    this.selectedClient.email = form.value.email;
    this.selectedClient.phoneNumber = form.value.phoneNumber;
    this.selectedClient.mobileNumber = form.value.mobileNumber;
    this.selectedClient.address = form.value.address;
    this.selectedClient.zipCode = form.value.zipCode;
    this.selectedClient.county = form.value.county;
    this.selectedClient.country = form.value.country;

<<<<<<< HEAD
    const updatedClient = JSON.stringify(this.selectedClient);
=======
    let updatedClient = JSON.stringify(this.selectedClient);
    console.log(updatedClient);
>>>>>>> André

    this.clientService.updateClient(updatedClient).pipe(first()).subscribe(response => {
      console.log(response);
      this.fetchClients();
      this.modalService.dismissAll();
<<<<<<< HEAD
      this.alertService.success('Cliente editado com sucesso!');
    }, error => {
      this.alertService.error(error.error.message);
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
    }
=======
    });
  }

  details(content, client) {
    this.selectedClient = client;
    this.clientToEdit = client;
    this.clientToEdit.birthDate = this.clientToEdit.birthDate.split('T')[0];
>>>>>>> André
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

<<<<<<< HEAD
  generatePassword(controlName: string) {
    let result = '';
    let characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    let charactersLength = characters.length;
    for (let i = 0; i < 15; i++) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }

    if (controlName === 'password') {
      this.newClient.loginPassword = result;
    } else {
      this.newClient.transactionPassword = result;
    }
  }

=======
>>>>>>> André
}
