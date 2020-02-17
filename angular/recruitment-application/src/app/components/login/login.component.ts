import { Component, OnInit } from '@angular/core';
import { AppService } from '../../app.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {username: '', password: ''};

  constructor(private http: HttpClient, private router: Router, private auth: AuthService) {}

  ngOnInit() {
  }

  /*login() {
    this.app.authenticate(this.credentials, () => {
        this.router.navigateByUrl('');
    });
    return false;
  }*/

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
