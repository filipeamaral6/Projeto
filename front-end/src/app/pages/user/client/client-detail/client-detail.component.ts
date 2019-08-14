import { Component, OnInit } from '@angular/core';
import { AdminLayoutComponent } from 'app/layouts/admin-layout/admin-layout.component';
import { Client } from 'app/shared/models/Client';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'client-detail-cmp',
  templateUrl: './client-detail.component.html',
  styleUrls: ['./client-detail.component.css']
})
export class ClientDetailComponent implements OnInit {

  client: Client;

  teste = 'ertyghjklkcmnjv hjhfbvjhbd';
  
  constructor(
    private adminLayout: AdminLayoutComponent) {
    }

  ngOnInit() {
    this.adminLayout.refreshData();
    this.client = this.adminLayout.getClient;
  }

}
