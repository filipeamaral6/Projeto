import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ToastrModule } from 'ngx-toastr';

import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule } from './shared/navbar/navbar.module';
import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';

import { LoginComponent } from './home/login/login.component';
import { HomeComponent } from './home/home.component';
import { LoadingSpinnerComponent } from './utils/loading-spinner/loading-spinner.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Globals } from './shared/Globals';
import { HttpClientModule } from '@angular/common/http';
import { ClientLayoutComponent } from './layouts/client-layout/client-layout.component';
import { AuthenticationService } from './services/authentication.service';
import { AccessService } from './services/access.service';
import { ClientService } from './services/transport/client.service';
import { AccountService } from './services/transport/account.service';
import { WorkerLayoutComponent } from './layouts/worker-layout/worker-layout.component';
import { SidebarModule } from './shared/sidebar/sidebar.module';
import { AlertComponent } from './shared/alerts/alert.component';
import { AlertService, AlertModule } from './shared/alerts';
import { TransactionService } from './services/transport/transaction.service';
import { EmployeeService } from './services/transport/employee.service';




@NgModule({
  declarations: [
    WorkerLayoutComponent,
    ClientLayoutComponent,
    AppComponent,
    LoginComponent,
    HomeComponent,
    LoadingSpinnerComponent],
  imports: [
    AlertModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(AppRoutes,
      {
        useHash: true
      }),
    SidebarModule,
    NavbarModule,
    ToastrModule.forRoot(),
    FooterModule,
    HttpClientModule,
  ],


  providers: [
    Globals,
    AuthenticationService,
    AccessService,
    ClientService,
    AccountService,
    TransactionService,
    EmployeeService
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
