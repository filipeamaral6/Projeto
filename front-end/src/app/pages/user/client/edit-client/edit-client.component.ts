import { Component, OnInit } from '@angular/core';
import { WorkerLayoutComponent } from 'app/layouts/worker-layout/worker-layout.component';
import { Client } from 'app/shared/models/Client';

@Component({
  selector: 'edit-client-cmp',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})
export class EditClientComponent implements OnInit {

  client: Client;

  constructor(
    private workerLayout: WorkerLayoutComponent) {
    }

  ngOnInit() {
    this.workerLayout.refreshData();
    this.client = this.workerLayout.getClient;
  }

}
