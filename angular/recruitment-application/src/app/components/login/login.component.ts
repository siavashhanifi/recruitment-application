import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  private password: string;
  private userName: string;
  private userService: UserService;

  private loginUser() {
    this.userService.userLogin(this.password, this.userName);
  }

}
