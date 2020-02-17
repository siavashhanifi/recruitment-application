import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private registerURL = 'api/auth/register';
  private loginURL = 'api/auth/login';
  private validURL = 'api/auth/validToken';

  constructor(private http: HttpClient, private router: Router) { }

  register(user: any) {

    return this.http.post(this.registerURL, user);
  }

  login(user: any) {
    return this.http.post(this.loginURL, user);
  }

  getToken() {
    return localStorage.getItem('token');
  }

  loggedIn(): boolean {
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

  logout() {
    localStorage.removeItem('token');
    this.router.navigateByUrl('/');
  }

  isAuthorized() {
    if (localStorage.getItem('role_id') === '2') {
      return true;
    } else { return false; }
  }
}
