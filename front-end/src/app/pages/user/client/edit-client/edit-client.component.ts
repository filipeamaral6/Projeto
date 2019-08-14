import { Component, OnInit } from '@angular/core';
import { AdminLayoutComponent } from 'app/layouts/admin-layout/admin-layout.component';
import { Client } from 'app/shared/models/Client';

@Component({
  selector: 'edit-client-cmp',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {

  client: Client;

  constructor(
    private adminLayout: AdminLayoutComponent) {
    }

  ngOnInit() {
    this.adminLayout.refreshData();
    this.client = this.adminLayout.getClient;
  }

}
