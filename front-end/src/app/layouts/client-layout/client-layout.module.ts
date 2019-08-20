import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ClientLayoutRoutes } from './client-layout.routing';

import { DashboardComponent } from '../../pages/user/client/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MovementsComponent } from 'app/pages/user/client/movements/movements.component';
import { PaymentsComponent } from 'app/pages/user/client/payments/payments.component';
import { TransferComponent } from 'app/pages/user/client/transfer/transfer.component';
import { ClientDetailComponent } from 'app/pages/user/client/client-detail/client-detail.component';
import { EditClientComponent } from 'app/pages/user/client/edit-client/edit-client.component';
import { ClientProfileComponent } from 'app/pages/user/client/client-profile/client-profile.component';
import { AccountListComponent } from 'app/shared/account-list/account-list.component';


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(ClientLayoutRoutes),
    FormsModule,
    NgbModule
  ],
  declarations: [
    DashboardComponent,
    UserComponent,
    MovementsComponent,
    PaymentsComponent,
    TransferComponent,
    ClientProfileComponent,
    ClientDetailComponent,
    EditClientComponent,
    AccountListComponent,
  ]
})

export class ClientLayoutModule { }
