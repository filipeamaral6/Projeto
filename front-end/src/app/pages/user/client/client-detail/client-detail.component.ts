import { Component, OnInit } from '@angular/core';
import { WorkerLayoutComponent } from 'app/layouts/worker-layout/worker-layout.component';
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
    private workerLayout: WorkerLayoutComponent) {
    }

  ngOnInit() {
    this.workerLayout.refreshData();
    this.client = this.workerLayout.getClient;
  }

}
