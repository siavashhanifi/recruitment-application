import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import * as jwt_decode from 'jwt-decode';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private registerURL = 'api/auth/register';
  private loginURL = 'api/auth/login';
  private validURL = 'api/auth/validToken';

  constructor(private http: HttpClient, private router: Router, ) {
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
    /*this.http.get(this.validURL).subscribe(
      res => {
        if (res['validToken']) {
          if (res['role'] === '2') {
            return true;
          } else {return false; }
        } else {
          return false;
        }
      },
      err => {
        return false;
        console.log(err);
      }
    );*/
  }

  loggedIn() {
    return !!localStorage.getItem('token');
  }

  logout() {
    localStorage.removeItem('token');
    this.router.navigateByUrl('/');
  }

  isAuthorized() {
    console.log('here');
    const token = jwt_decode(localStorage.getItem('token'));
    console.log(token);
    if (token['role_id'] === 2) {
      return true;
    } else { return false; }
  }
}
