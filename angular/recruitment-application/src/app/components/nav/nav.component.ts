import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AuthService } from '../../auth.service';

/**
 * Component NavComponent representing a navigation bar for navigation.
 * Component decorator containing selector, template url and style urls.
 * The selector is used for identifying the component in html.
 * The template url defines the html associated to the component.
 * The sytle url defines the stylesheets related to the component.
 */
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})


export class NavComponent implements OnInit {

  /**
   * Event output for signaling language change
   */
  @Output() langChangedEventEmitter = new EventEmitter<string>();

  /**
   * Emits a change of language on user inteface
   * @param lang (swedish/english)
   */
  public changeLang(lang: string){
    this.langChangedEventEmitter.emit(lang);
  }
  /**
   * Creates an instance of nav component.
   * @param authService instance of the service responsible for handling authentication.
   * In this class used for retrieving the authentication status of the current user.
   */
  constructor(public authService: AuthService) { }

  ngOnInit() {
  }

}
