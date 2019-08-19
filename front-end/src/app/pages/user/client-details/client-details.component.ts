import { Component, OnInit, Input } from '@angular/core';
import { AdminLayoutComponent } from 'app/layouts/admin-layout/admin-layout.component';
import { Client } from 'app/shared/models/Client';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthenticationService } from 'app/services/authentication.service';


@Component({
  selector: 'app-client-details',
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.css']
})
export class ClientDetailsComponent implements OnInit {

  @Input() editMode: boolean;

  private permitedFields: string[];

  isClient = false;
  isOperator = false;
  isAdmin = false;

  teste = '123teste'

  initClient: Client;
  client: Client;
  clientForm: FormGroup;

  constructor(
    private authenticationService: AuthenticationService,
    private adminLayout: AdminLayoutComponent,
    private formBuilder: FormBuilder
    ) {
      switch (authenticationService.currentUser.role) {
        case 'CLIENT':
          this.isClient = true;
          this.permitedFields = ['email', 'phoneNumber', 'mobileNumber'];
          break;
        case 'OPERATOR':
          this.isOperator = true;
          this.permitedFields = ['email', 'phoneNumber', 'mobileNumber', 'notification'];
          break;
        case 'ADMIN':
          this.isAdmin = true;
          this.permitedFields = ['email', 'phoneNumber', 'mobileNumber', 'notification'];
          break;
      }
    }

  ngOnInit() {
    this.adminLayout.refreshData();
    this.client = this.adminLayout.getClient;
    this.initClient = this.client;

    this.clientForm = this.formBuilder.group({
      userId:       ['', Validators.required],
      username:     ['', Validators.required],
      email:        ['', Validators.required],
      createdAt:    ['', Validators.required],
      role:         ['', Validators.required],
      fullName:     ['', Validators.required],
      birthDate:    ['', Validators.required],
      nif:          ['', Validators.required],
      clientCC:     ['', Validators.required],
      nationality:  ['', Validators.required],
      phoneNumber:  ['', Validators],
      mobileNumber: ['', Validators],
      address:      ['', Validators.required],
      zipCode:      ['', Validators.required],
      county:       ['', Validators.required],
      country:      ['', Validators.required],
      notification: ['', Validators.required],
      status:       ['', Validators.required]
    });
  }

  checkNotificationStatus() {
    if (this.client.notification === 'TRUE') {
      return true;
    }
    return false;
  }

  checkClientStatus() {
    if (this.client.status === 'ACTIVE') {
      return true;
    }
    return false;
  }

  resetClientData() {
    this.client = this.initClient;
  }

  onSubmit() {

    // stop here if form is invalid
    if (this.clientForm.invalid) {
      return;
    }
    console.log('Submited')
  }

  fieldStyle(field: string) {
    console.log(field);
    let styles = {
      'background-color': 'white'
    }
    if ( !this.editMode ) {
      return styles;
    }
    if ( this.editMode ) {
      styles = {
        'background-color': 'rgb(248, 248, 248)'
      }
      switch (this.authenticationService.currentUser.role) {
        case 'CLIENT':
          this.permitedFields.forEach(clientField => {
            if ( clientField === field) {
              styles = {
                'background-color': 'white'
              }
              return styles;
            }
          });
          break;
        case 'OPERATOR':
        case 'ADMIN':
        default:
          break;
      }
    }
  }

}
