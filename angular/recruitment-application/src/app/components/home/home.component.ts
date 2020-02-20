import { Component, OnInit } from '@angular/core';

/**
 * Component decorator containing selector, template url and style urls.
 * The selector is used for identifying the component in html.
 * The template url defines the html associated to the component.
 * The sytle url defines the stylesheets related to the component.
 */
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
