import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.css']
})
export class ClientsComponent implements OnInit {
  clients: Client[];
  selectedRow: number;

  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.fetchClients();
  }

  fetchClients() {
    this.clientService.getAll().pipe(first()).subscribe(clients => {
      console.log(clients);
      this.clients = clients;
    });
  }

  getClientDetails(id: number) {
    this.clientService.getById(id).pipe(first()).subscribe(client => {
      console.log(client);
    });
  }

  setClickedRow(index: number) {
    this.selectedRow = index;
  }
}
