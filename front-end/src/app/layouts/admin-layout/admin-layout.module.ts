import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { AdminLayoutRoutes } from './admin-layout.routing';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MovementsComponent } from 'app/pages/movements/movements.component';
import { PaymentsComponent } from 'app/pages/payments/payments.component';
import { TransferComponent } from 'app/pages/transfer/transfer.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    NgbModule
  ],
  declarations: [
    DashboardComponent,
    UserComponent,
    MovementsComponent,
    PaymentsComponent,
    TransferComponent
  ]
})

export class AdminLayoutModule { }
