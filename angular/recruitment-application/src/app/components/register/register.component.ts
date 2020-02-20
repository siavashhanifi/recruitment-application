import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthService } from '../../auth.service';

/**
 * Component RegisterComponent representing the registration interface of the web application.
 * Component decorator containing selector, template url and style urls.
 * The selector is used for identifying the component in html.
 * The template url defines the html associated to the component.
 * The sytle url defines the stylesheets related to the component.
 */
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  /**
   * Credentials  of register component. Variables containing user input from the registration form,
   * representing a user registred user of the web application.
   */
  credentials = {name: '', surname: '', email: '', username: '', password: '', ssn: '', role_id: '1'};

  /**
   * Creates an instance of register component.
   * @param http instance of HttpClient responsible for http communication with backend server
   * @param router instance of frontend router for page navigation
   * @param auth  instance of a service respinsible for backend server communication ralated to authentication
   */
  constructor(private http: HttpClient, private router: Router, private auth: AuthService) { }

  ngOnInit() {
  }

  /**
   * Method called when a user submits a registration form. Calls the registration handler in authservice
   * (@see ../../auth.service#register()). Either redirects to login page at successful registration, or
   * alerts the user on potential errors.
   */
  register() {
    this.auth.register(this.credentials)
      .subscribe(
        res => this.router.navigateByUrl('login'),
        err => {console.log(err); window.alert(err.error.message);}
      );
  }
}
