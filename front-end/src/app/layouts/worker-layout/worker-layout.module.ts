import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { WorkerLayoutRoutes } from './worker-layout.routing';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { UsersComponent } from 'app/pages/user/worker/users/users.component';
import { DepositComponent } from 'app/pages/user/worker/deposit/deposit.component';
import { PaymentsComponent } from 'app/pages/user/worker/payments/payments.component';
import { TransferComponent } from 'app/pages/user/worker/transfer/transfer.component';



@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(WorkerLayoutRoutes),
    FormsModule,
    NgbModule
  ],
  declarations: [
    UsersComponent,
    DepositComponent,
    PaymentsComponent,
    TransferComponent
  ]
})

export class WorkerLayoutModule { }
