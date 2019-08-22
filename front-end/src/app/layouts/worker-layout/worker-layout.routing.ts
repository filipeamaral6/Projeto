import { Routes } from '@angular/router';
import { DepositComponent } from 'app/pages/user/worker/deposit/deposit.component';
import { TransferComponent } from 'app/pages/user/worker/transfer/transfer.component';
import { PaymentsComponent } from 'app/pages/user/worker/payments/payments.component';
import { ClientsComponent } from 'app/pages/user/worker/clients/clients.component';


export const WorkerLayoutRoutes: Routes = [
  { path: 'clients', component: ClientsComponent },
  { path: 'deposit', component: DepositComponent },
  { path: 'transfer', component: TransferComponent },
  { path: 'payments', component: PaymentsComponent }
];
