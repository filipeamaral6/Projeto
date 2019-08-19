import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { WorkerLayoutComponent } from 'app/layouts/worker-layout/worker-layout.component';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'payments-cmp',
  moduleId: module.id,
  templateUrl: 'payments.component.html'
})

export class PaymentsComponent implements OnInit {
  client: Client;

  constructor(
    private workerLayout: WorkerLayoutComponent
  ) {
    this.workerLayout.refreshData();
    this.client = this.workerLayout.getClient;
  }



  ngOnInit() {
    console.log(this.client);
  }
}
