import { Routes } from '@angular/router';
import { DepositComponent } from 'app/pages/user/worker/deposit/deposit.component';
import { TransferComponent } from 'app/pages/user/worker/transfer/transfer.component';
import { PaymentsComponent } from 'app/pages/user/worker/payments/payments.component';
import { ClientsComponent } from 'app/pages/user/worker/clients/clients.component';
import { AccountsComponent } from 'app/pages/user/worker/accounts/accounts.component';
import { EmployeesComponent } from 'app/pages/user/worker/employees/employees.component';
import { EmployeeGuard } from 'app/guards/employee.guard';
import { AdminGuard } from 'app/guards/admin.guard';


export const WorkerLayoutRoutes: Routes = [
  { path: 'clients', component: ClientsComponent, canActivate: [EmployeeGuard] },
  { path: 'deposit', component: DepositComponent, canActivate: [EmployeeGuard] },
  { path: 'transfer', component: TransferComponent, canActivate: [EmployeeGuard] },
  { path: 'payments', component: PaymentsComponent, canActivate: [EmployeeGuard] },
  { path: 'accounts', component: AccountsComponent, canActivate: [EmployeeGuard] },
  { path: 'employees', component: EmployeesComponent, canActivate: [AdminGuard] }
];
