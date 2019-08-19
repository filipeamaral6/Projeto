import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'app/app.component';
import { Router, Route } from '@angular/router';
import { WorkerLayoutComponent } from 'app/layouts/worker-layout/worker-layout.component';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'movements-cmp',
  moduleId: module.id,
  templateUrl: 'movements.component.html',
  styleUrls: ['movements.component.css']
})

export class MovementsComponent implements OnInit {
  accounts: any[];
  selectedAccount;

  constructor(
    private appComponent: AppComponent,
    private router: Router,
    private workerLayout: WorkerLayoutComponent
    ) {
      this.workerLayout.refreshData();
    }

  ngOnInit() {
    this.accounts = this.appComponent.user.accounts;
  }

  onSelectAccount(index: number) {
    this.selectedAccount = this.accounts.slice(index, index + 1);
    console.log(this.selectedAccount);
  }
}
