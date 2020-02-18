import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private auth: AuthService, private router: Router) {}

  canActivate(): boolean {
    const isValid: Observable<boolean> = this.auth.isValid();
    const isAuthorized: boolean = this.auth.isAuthorized();
    if (isAuthorized && isValid) {
      return true;
    } else {
      this.router.navigateByUrl('login');
      return false;
    }
  }
}
