import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { AdminLayoutComponent } from 'app/layouts/admin-layout/admin-layout.component';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'payments-cmp',
  moduleId: module.id,
  templateUrl: 'payments.component.html'
})

export class PaymentsComponent implements OnInit {
  client: Client;

  constructor(
    private adminLayout: AdminLayoutComponent
  ) {
    this.adminLayout.refreshData();
    this.client = this.adminLayout.getClient;
  }



  ngOnInit() {
    console.log(this.client);
  }
}
