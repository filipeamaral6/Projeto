import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'app/services/authentication.service';
import { AccessService } from 'app/services/access.service';
import { User } from 'app/shared/models/User';
import { AlertService } from 'app/shared/alerts';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  isLoading = false;
  submitted = false;
  isTakingAWhile = false;
  currentUser: User;
  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
    private accessService: AccessService,
    private alertService: AlertService,

  ) {
    if (this.accessService.isLoggedIn) {
      this.router.navigate(['/']);
    }
  }

  ngOnInit() {

    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  onSubmit() {

    this.submitted = true;

    // reset alerts on submit
    //    this.alertService.clear();

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.isLoading = true;
    setTimeout(() => { this.isTakingAWhile = true; }, 2000);
    this.authenticationService.login(this.f.username.value, this.f.password.value)

      .pipe(first())
      .subscribe(
        data => {
          const role = data.role;
          console.log(data);
          if (role === 'CLIENT') {
            this.router.navigate(['/client/dashboard']);
          } else {
            this.router.navigate(['/worker/clients']);
          }
        },

        error => {
          console.log(error);
          if (error.error.status === 401) {
            this.alertService.error('Username ou password incorreta');
          } else {
            this.alertService.error(error.error.message);
          }
          this.isLoading = false;
          this.isTakingAWhile = false;
        });
  }


}
