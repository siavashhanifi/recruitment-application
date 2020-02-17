import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private registerURL = 'api/auth/register';
  private loginURL = 'api/auth/login';

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

  loggedIn() {
    return !!localStorage.getItem('token');
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigateByUrl('/');
  }
}
