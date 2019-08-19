import { Component, OnInit } from '@angular/core';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';
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
    private clientLayout: ClientLayoutComponent) {
    }

  ngOnInit() {
    this.clientLayout.refreshData();
    this.client = this.clientLayout.getClient;
  }

}
