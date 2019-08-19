import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'payments-cmp',
  moduleId: module.id,
  templateUrl: 'payments.component.html'
})

export class PaymentsComponent implements OnInit {
  client: Client;

  constructor(
    private clientLayout: ClientLayoutComponent
  ) {
    this.clientLayout.refreshData();
    this.client = this.clientLayout.getClient;
  }



  ngOnInit() {
    console.log(this.client);
  }
}
