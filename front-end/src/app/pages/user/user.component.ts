import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { WorkerLayoutComponent } from 'app/layouts/worker-layout/worker-layout.component';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'user-cmp',
  moduleId: module.id,
  templateUrl: 'user.component.html'
})

export class UserComponent implements OnInit {

  isEditing = false;

  client: Client;

  constructor(
    private workerLayout: WorkerLayoutComponent) {
    }

  ngOnInit() {
    this.workerLayout.refreshData();
    this.client = this.workerLayout.getClient;
  }

  editMode() {
    this.isEditing = true;
    console.log(this.isEditing);
  }

  exitEditMode() {
    this.isEditing = false;
    console.log(this.isEditing);
  }

}
