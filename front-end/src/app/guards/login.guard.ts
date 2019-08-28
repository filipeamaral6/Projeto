import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';

@Injectable({ providedIn: 'root' })
export class LoginGuard implements CanActivate {
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const currentUser = this.authenticationService.currentUserValue;
        console.log(currentUser);
        if (currentUser && (currentUser.role === 'ADMIN' || currentUser.role === 'EMPLOYEE')) {
            this.router.navigate(['/worker/clients']);
            return false;
        }
        if (currentUser && currentUser.role === 'CLIENT') {
            this.router.navigate(['/client/dashboard']);
            return false;
        }
        return true;
    }
}
