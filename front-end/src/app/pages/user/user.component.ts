import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { AdminLayoutComponent } from 'app/layouts/admin-layout/admin-layout.component';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'user-cmp',
  moduleId: module.id,
  templateUrl: 'user.component.html'
})

export class UserComponent implements OnInit {

  client: Client;

  constructor(
    private adminLayout: AdminLayoutComponent) {
    }

  ngOnInit() {
    this.adminLayout.refreshData();
    this.client = this.adminLayout.getClient;
  }
}
