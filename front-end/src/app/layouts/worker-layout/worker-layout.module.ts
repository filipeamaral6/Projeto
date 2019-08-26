import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { WorkerLayoutRoutes } from './worker-layout.routing';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ClientsComponent } from 'app/pages/user/worker/clients/clients.component';
import { DepositComponent } from 'app/pages/user/worker/deposit/deposit.component';
import { PaymentsComponent } from 'app/pages/user/worker/payments/payments.component';
import { TransferComponent } from 'app/pages/user/worker/transfer/transfer.component';
import { AlertModule } from 'app/shared/alerts';
import { AccountsComponent } from 'app/pages/user/worker/accounts/accounts.component';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown-angular7';



@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(WorkerLayoutRoutes),
    FormsModule,
    NgbModule,
    AlertModule,
    NgMultiSelectDropDownModule.forRoot()
  ],
  declarations: [
    ClientsComponent,
    DepositComponent,
    PaymentsComponent,
    TransferComponent,
    AccountsComponent
  ]
})

export class WorkerLayoutModule { }
