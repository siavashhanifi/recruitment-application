import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import {JwtHelperService} from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private registerURL = 'api/auth/register';
  private loginURL = 'api/auth/login';
  private validURL = 'api/auth/validToken';
  private helper:JwtHelperService;

  constructor(private http: HttpClient, private router: Router, ) { 
    this.helper = new JwtHelperService();
  }

  register(user: any) {

    return this.http.post(this.registerURL, user);
  }

  login(user: any) {
    return this.http.post(this.loginURL, user);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  isValid(): any {
    this.http.get(this.validURL).subscribe(
      res => {
        if (res['validToken']) {
          return !!localStorage.getItem('token');
        } else {
          return false;
        }
      },
      err => {
        console.log(err);
        return false;
      }
    );
  }

  loggedIn(){
    return !!localStorage.getItem('token');
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigateByUrl('/');
  }

  isAuthorized() {
    console.log('here');
    var token = this.helper.decodeToken(localStorage.getItem('token'));
    console.log(token);
    if (token["role_id"]==2) {
      return true;
    } else { return false; }
  }
}
