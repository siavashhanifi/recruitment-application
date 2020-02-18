import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  credentials = {email: '', password: ''};

  constructor(private http: HttpClient, private router: Router, private auth: AuthService) {}

  login() {
    this.auth.login(this.credentials)
      .subscribe(
        res => {
          console.log(res);
          localStorage.setItem('token', res['token']);
          this.router.navigateByUrl('');
        },
        err => {console.log(err); console.log('hej'); }
      );
  }
}
