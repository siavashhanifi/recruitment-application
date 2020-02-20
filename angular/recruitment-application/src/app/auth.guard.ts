import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthService } from './auth.service';
import { Observable } from 'rxjs';

/**
 * Guard injectable used for controlling site flow. Sets directives for which pages can be
 * accessed by different users depending on authorization.
 *
 * @export
 * @class AuthGuard
 * @implements {CanActivate}
 */
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  /**
   * Creates an instance of auth guard.
   * @param router instance of frontend router for page navigation
   * @param auth  instance of a service respinsible for backend server communication ralated to authentication
   */
  constructor(private auth: AuthService, private router: Router) {}


  /**
   * Method for determining if a user is a valid user, and if the user is authorized to open different pages.
   * If not valid user, or not authorized, the user is redirected to the login page.
   *
   * @returns {boolean}
   * @memberof AuthGuard
   */
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
