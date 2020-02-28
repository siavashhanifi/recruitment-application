import { Component } from '@angular/core';
import {TranslateService} from '@ngx-translate/core';
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

  public updateLanguage(lang){
    this.translate.use(lang);
  }

  constructor(private translate: TranslateService) {
    // this language will be used as a fallback when a translation isn't found in the current language
    translate.setDefaultLang('en');
     // the lang to use, if the lang isn't available, it will use the current loader to get them
    translate.use('en');
  }

}
