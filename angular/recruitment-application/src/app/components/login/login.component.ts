import { Component } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { AuthService } from "../../auth.service";
import { FormGroup, FormControl, Validators } from "@angular/forms";
/**
 * Component LoginComponent representing the login interface of the web application.
 * Component decorator containing selector, template url and style urls.
 * The selector is used for identifying the component in html.
 * The template url defines the html associated to the component.
 * The sytle url defines the stylesheets related to the component.
 */
@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent {
  /**
   * Credentials  of login component. Variables containing user input from a login-attempt.
   */
  credentials = { email: "", password: "" };
  submitted;
  loginForm: FormGroup;
  /**
   * Creates an instance of login component.
   * @param http instance of HttpClient responsible for http communication with backend server
   * @param router instance of frontend router for page navigation
   * @param auth  instance of a service respinsible for backend server communication ralated to authentication
   */
  constructor(
    private http: HttpClient,
    private router: Router,
    private auth: AuthService
  ) {}

  /**
   * Method called at a login attempt. If the login form is valid, a call is made to the login handler in authservice (@see ../../auth.service#login())
   * and recieves an observable. If a valid response is returned, the token passed from backend is stored
   * in the local storage (the user is logged in) and redirects to the main page.
   */
  login() {
    this.submitted = true;
    if (this.loginForm.invalid) return;

    this.auth.login(this.credentials).subscribe(
      res => {
        console.log(res);
        localStorage.setItem("token", res["token"]);
        this.router.navigateByUrl("");
      },
      err => {
        console.log(err);
        window.alert(err.error.message);
      }
    );
  }

  get f() {
    return this.loginForm.controls;
  }

  ngOnInit() {
    this.submitted = false;
    this.loginForm = new FormGroup({
      email: new FormControl(this.credentials.email, [
        Validators.required,
        Validators.email
      ]),
      password: new FormControl(this.credentials.password, [
        Validators.required
      ])
    });
  }
}
