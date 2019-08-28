import { Component, OnInit } from '@angular/core';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'app/services/authentication.service';
import { AlertService } from 'app/shared/alerts';

@Component({
  // tslint:disable-next-line: component-selector
  selector: 'client-detail-cmp',
  templateUrl: './client-detail.component.html',
  styleUrls: ['./client-detail.component.css']
})
export class ClientDetailComponent implements OnInit {

  client: Client;
  notificationStatus = false;

  constructor(
    private clientService: ClientService,
    private authenticationService: AuthenticationService,
    private alertService: AlertService) {
  }

  ngOnInit() {
    this.getClientInfo();
  }

  private getClientInfo() {
    this.clientService.getById(this.authenticationService.currentUser.id).pipe(first()).subscribe(client => {
      this.client = client[0];
      this.checkNotificationStatus();
    });
  }

  public checkNotificationStatus() {
    if (this.client.notification === 'TRUE') {
      this.notificationStatus = true;
    } else {
      this.notificationStatus = false;
    }
  }

  public changeNotificationStatus() {

    this.client.birthDate = this.client.birthDate.substring(0, 10);
    if (this.client.notification === 'TRUE') {
      this.client.notification = 'FALSE';
    } else {
      this.client.notification = 'TRUE';
    }
    console.log(this.client);

    const clientToJSON = JSON.stringify(this.client);

    this.clientService.updateClient(clientToJSON)
      .pipe(first())
      .subscribe(
        data => {
          this.alertService.success('Notificação por email atualizada com sucesso!');
        },
        error => {
          console.log(error);
          this.alertService.error(error.message);
        });
  }
}


