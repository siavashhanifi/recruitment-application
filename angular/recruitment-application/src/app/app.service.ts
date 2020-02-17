import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  authenticated = false;
  registred: boolean;

  constructor(private http: HttpClient) { }

  authenticate(credentials: any, callback: CallableFunction) {

    const headers = {
      username : credentials.username,
      password : credentials.password
    };

    this.http.post('/api/auth/login', credentials).subscribe(response => {
      console.log(response);
      console.log(response['login-success']);
      this.authenticated = response['login-success'];

      return callback && callback();
    });
  }

  register(credentials: any, callback: CallableFunction) {

    const headers = {
      name : credentials.name,
      surname : credentials.surname,
      ssn : credentials.ssn,
      email : credentials.email,
      password : credentials.password,
      role_id : credentials.role_id,
      username : credentials.username
    };

    this.http.post('/api/auth/register', credentials).subscribe(response => {
      if (response) {
        this.registred = true;
      } else {
        this.registred = false;
      }
    });
  }
}
