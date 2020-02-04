import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  authenticated = false;
  registred: boolean;

  constructor(private http: HttpClient) { }

  authenticate(credentials, callback) {
    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.post('/api/auth/login', {headers}).subscribe(response => {
      if (response) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return callback && callback();
    });
  }

  register(credentials, callback) {
   /* const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic' + btoa(
        credentials.firstName + ':'
        + credentials.lastName + ':'
        + credentials.email + ':'
        + credentials.username + ':'
        + credentials.password)
    } : {});*/
    const headers = {
      name : credentials.name,
      surname : credentials.surname,
      email : credentials.email,
      ssn : credentials.ssn,
      username : credentials.username,
      password : credentials.password,
      role_id : credentials.role_id
    };

    this.http.post('/api/auth/register', {headers}).subscribe(response => {
      if (response) {
        this.registred = true;
      } else {
        this.registred = false;
      }
    });
  }
}
