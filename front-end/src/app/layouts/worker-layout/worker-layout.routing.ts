import { Routes } from '@angular/router';
import { UsersComponent } from 'app/pages/user/worker/users/users.component';
import { DepositComponent } from 'app/pages/user/worker/deposit/deposit.component';
import { TransferComponent } from 'app/pages/user/worker/transfer/transfer.component';
import { PaymentsComponent } from 'app/pages/user/worker/payments/payments.component';


export const WorkerLayoutRoutes: Routes = [
  { path: 'users', component: UsersComponent },
  { path: 'deposit', component: DepositComponent },
  { path: 'users', component: UsersComponent },
  { path: 'transfer', component: TransferComponent },
  { path: 'payments', component: PaymentsComponent }
];
