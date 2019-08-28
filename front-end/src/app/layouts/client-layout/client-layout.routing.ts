import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/user/client/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';
import { MovementsComponent } from 'app/pages/user/client/movements/movements.component';
import { PaymentsComponent } from 'app/pages/user/client/payments/payments.component';
import { TransferComponent } from 'app/pages/user/client/transfer/transfer.component';
import { ClientGuard } from 'app/guards/client.guard';

export const ClientLayoutRoutes: Routes = [
  { path: 'dashboard', component: DashboardComponent, canActivate: [ClientGuard] },
  { path: 'user', component: UserComponent, canActivate: [ClientGuard] },
  { path: 'movements', component: MovementsComponent, canActivate: [ClientGuard] },
  { path: 'payments', component: PaymentsComponent, canActivate: [ClientGuard] },
  { path: 'transfer', component: TransferComponent, canActivate: [ClientGuard] }
];
