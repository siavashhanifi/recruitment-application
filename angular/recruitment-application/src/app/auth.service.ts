import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import * as jwt_decode from 'jwt-decode';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

/**
 * Class AuthService responsible for backend communication related to user authorization.
 *
 * @export
 */
@Injectable({
  providedIn: 'root'
})
export class AuthService {


  /**
   * registrationURL: url for backend registration handling
   * loginURL: url for backend login handling
   * validURL: url for backend token validation
   */
  private registerURL = 'api/auth/register';
  private loginURL = 'api/auth/login';
  private validURL = 'api/auth/validToken';


  /**
   * Creates an instance of AuthService.
   * @param http instance of HttpClient responsible for http communication with backend server
   * @param router instance of frontend router for page navigation
   */
  constructor(private http: HttpClient, private router: Router, ) {
  }


  /**
   * register method sends post-request to backend registration handling, passing the new user object
   * as argument
   *
   * @param user
   * @returns observable response of backend register process.
   */
  register(user: any) {

    return this.http.post(this.registerURL, user);
  }


  /**
   * login method sends post-request to backend for login handling, passing the login-cridentials
   * as argument. JWT-token included in response header if login was successful.
   *
   * @param user
   * @returns observable response of backend login process
   */
  login(user: any) {
    return this.http.post(this.loginURL, user);
  }


  /**
   * Method for retrieving JWT-token from local storage.
   *
   * @returns JWT-token
   */
  getToken() {
    return localStorage.getItem('token');
  }


  /**
   * Method for validation of current token stored in local storage through a get-request
   * to the backend server
   *
   * @returns observable returning true if token is valid.
   */
  isValid(): Observable<boolean> {
    let valid: Observable<boolean>;

    valid = this.http.get(this.validURL).pipe(
      map((
        res => {
          if (res['validToken'] === 'true') {
              return true;
          } else { return false; }
        }
      ))
    );
    console.log(valid);
    return valid;
  }


  /**
   * Method for checking if the user is logged in, only affecting fronend.
   *
   * @returns boolean true or false, if a JWT-token is found or not.
   */
  loggedIn() {
    return !!localStorage.getItem('token');
  }


  /**
   * Method for removing the JWT-token form local storage, equvivalent to logging out.
   *
   */
  logout() {
    localStorage.removeItem('token');
    this.router.navigateByUrl('/');
  }


  /**
   * Method for controlling if a user is of the correct authorization level to access specific pages.
   *
   * @returns boolean, authorized or not.
   */
  isAuthorized() {
    const token = jwt_decode(localStorage.getItem('token'));
    console.log(token);
    if (token['role_id'] === 2) {
      return true;
    } else { return false; }
  }
}
