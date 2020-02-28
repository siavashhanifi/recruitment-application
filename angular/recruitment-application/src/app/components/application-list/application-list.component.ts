import { Component, OnInit } from '@angular/core';
import { Application } from 'src/app/enteties/application.entety';
import { ApplicationService } from 'src/app/application.service';

/**
 * Component ApplicationListComponent representing a page for listing all posted applications.
 * Component decorator containing selector, template url and style urls.
 * The selector is used for identifying the component in html.
 * The template url defines the html associated to the component.
 * The sytle url defines the stylesheets related to the component.
 */
@Component({
  selector: 'app-application-list',
  templateUrl: './application-list.component.html',
  styleUrls: ['./application-list.component.css']
})
export class ApplicationListComponent implements OnInit {

  applications: Application[];

  constructor(private applicationService: ApplicationService) { }

  ngOnInit() {
    this.applications = this.applicationService.findAll();
  }

}

