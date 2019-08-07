import { Component, OnInit } from '@angular/core';
import { User } from 'app/shared/model/user.model';
import { AppComponent } from 'app/app.component';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'user-cmp',
  moduleId: module.id,
  templateUrl: 'user.component.html'
})

export class UserComponent implements OnInit {
  user: User;

  constructor(private appComponent: AppComponent) {}

  ngOnInit() {
    this.user = this.appComponent.user;
  }
}
