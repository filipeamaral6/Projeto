import { Component, OnInit } from '@angular/core';
import { User } from 'app/shared/model/user.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthenticationService } from 'app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  isLoading = false;
  submitted = false;
  isTakingAWhile = false;
  returnUrl: string;
  currentUser: User;
  loginForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService,
//    private alertService: AlertService,

  ) {
    if ( this.authenticationService.isLoggedIn ) {
      this.router.navigate(['/']);
    }
  }

  ngOnInit() {

     this.loginForm = this.formBuilder.group({
       username: ['', Validators.required],
       password: ['', Validators.required]
     });

    // get return url from route parameters or default to '/'
    this.returnUrl = '/application';
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
            this.router.navigate([this.returnUrl]);
        },

        error => {
//          this.alertService.error(error.message);
          this.isLoading = false;
          this.isTakingAWhile = false;
        });
   }


}
