import { Component, OnInit } from '@angular/core';
import { ClientLayoutComponent } from 'app/layouts/client-layout/client-layout.component';
import { Client } from 'app/shared/models/Client';
import { ClientService } from 'app/services/transport/client.service';
import { CurrentUser } from 'app/shared/models/CurrentUser';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'app/services/authentication.service';

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
    private authenticationService: AuthenticationService) {
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

    const clientToJSON = JSON.stringify(this.client);

    this.clientService.updateClient(clientToJSON)
      .pipe(first())
      .subscribe(
        data => {
          alert('Notificação por email atualizada com sucesso!');
        },
        error => {
        });
  }
}


