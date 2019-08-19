import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/user/client/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';
import { MovementsComponent } from 'app/pages/user/client/movements/movements.component';
import { PaymentsComponent } from 'app/pages/user/client/payments/payments.component';
import { TransferComponent } from 'app/pages/user/client/transfer/transfer.component';
import { AuthGuard } from 'app/guards/auth.guard';

export const ClientLayoutRoutes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'user', component: UserComponent },
  { path: 'movements', component: MovementsComponent },
  { path: 'payments', component: PaymentsComponent },
  { path: 'transfer', component: TransferComponent }
];
