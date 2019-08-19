import { Component, OnInit } from '@angular/core';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';
import { Client } from 'app/shared/models/Client';

@Component({
  selector: 'edit-client-cmp',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {

  client: Client;

  constructor(
    private clientLayout: ClientLayoutComponent) {
    }

  ngOnInit() {
    this.clientLayout.refreshData();
    this.client = this.clientLayout.getClient;
  }

}
