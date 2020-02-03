import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  uri = 'http://localhost:4010';

  constructor(private http: HttpClient) {}

  userLogin(user: string, pswd: string) {

    const loginCridentials = {
      userName: user,
      password: pswd
    };

    return this.http.post(`${this.uri}/login`, loginCridentials);
  }
}
