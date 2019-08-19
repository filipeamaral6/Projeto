import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';
import { MovementsComponent } from 'app/pages/movements/movements.component';
import { PaymentsComponent } from 'app/pages/payments/payments.component';
import { TransferComponent } from 'app/pages/transfer/transfer.component';
import { AuthGuard } from 'app/guards/auth.guard';

export const ClientLayoutRoutes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'user', component: UserComponent },
  { path: 'movements', component: MovementsComponent },
  { path: 'payments', component: PaymentsComponent },
  { path: 'transfer', component: TransferComponent }
];
