import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';

//adicionar a data correta ao modal

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.css']
})
export class ClientsComponent implements OnInit {
  clients: Client[];
  selectedClient: Client;
  clientToEdit: Client;
  editMode = false;
  editButtonLabel = 'Editar Dados';

  constructor(private clientService: ClientService, config: NgbModalConfig, private modalService: NgbModal) { }

  ngOnInit() {
    this.fetchClients();
  }

  fetchClients() {
    this.clientService.getAll().pipe(first()).subscribe(clients => {
      this.clients = clients;
    });
  }

  updateClient(form: NgForm) {
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

    let updatedClient = JSON.stringify(this.selectedClient);
    console.log(updatedClient);

    this.clientService.updateClient(updatedClient).pipe(first()).subscribe(response => {
      console.log(response);
      this.fetchClients();
      this.modalService.dismissAll();
    });
  }

  details(content, client) {
    this.selectedClient = client;
    this.clientToEdit = client;
    this.clientToEdit.birthDate = this.clientToEdit.birthDate.split('T')[0];
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

}
