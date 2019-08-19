import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { WorkerLayoutRoutes } from './worker-layout.routing';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MovementsComponent } from 'app/pages/movements/movements.component';
import { PaymentsComponent } from 'app/pages/payments/payments.component';
import { TransferComponent } from 'app/pages/transfer/transfer.component';
import { ClientDetailComponent } from 'app/pages/user/client/client-detail/client-detail.component';
import { EditClientComponent } from 'app/pages/user/client/edit-client/edit-client.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(WorkerLayoutRoutes),
    FormsModule,
    NgbModule
  ],
  declarations: [
    DashboardComponent,
    UserComponent,
    MovementsComponent,
    PaymentsComponent,
    TransferComponent,
    ClientDetailComponent,
    EditClientComponent
  ]
})

export class WorkerLayoutModule { }
