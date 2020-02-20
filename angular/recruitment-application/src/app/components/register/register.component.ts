import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  credentials = {name: '', surname: '', email: '', username: '', password: '', ssn: '', role_id: '1'};

  constructor(private http: HttpClient, private router: Router, private auth: AuthService) { }

  ngOnInit() {
  }

  register() {
    this.auth.register(this.credentials)
      .subscribe(
        res => this.router.navigateByUrl('login'),
        err => {console.log(err); window.alert(err.error.message);}
      );
  }
}
