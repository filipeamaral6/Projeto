import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';

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
    private clientLayout: ClientLayoutComponent) {
    }

  ngOnInit() {
    this.clientLayout.refreshData();

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
