import { Component, OnInit } from '@angular/core';
import { AppService } from '../../app.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  credentials = {name: '', surname: '', email: '', username: '', password: '', ssn: '', role_id: '1'};

  constructor(private app: AppService, private http: HttpClient, private router: Router) { }

  ngOnInit() {
  }

  register() {
    this.app.register(this.credentials, () => {
        this.router.navigateByUrl('login');
    });
    return false;
  }
}
