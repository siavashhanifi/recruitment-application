import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/finally';

/**
 * Component decorator containing selector, template url and style urls.
 * The selector is used for identifying the component in html.
 * The template url defines the html associated to the component.
 * The sytle url defines the stylesheets related to the component.
 * @export
 * @class AppComponent with application title
 */
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'recruitment-application';
}
