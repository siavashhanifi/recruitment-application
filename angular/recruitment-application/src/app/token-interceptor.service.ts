import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { AuthService } from './auth.service';


/**
 * Class implementing HttpInterceptor, responsible for formating http-requests.
 *
 * @export
 * @class TokenInterceptorService
 * @implements {HttpInterceptor}
 */
@Injectable({
  providedIn: 'root'
})
export class TokenInterceptorService implements HttpInterceptor {


  /**
   * Creates an instance of TokenInterceptorService.
   * @param {Injector} injector
   * @memberof TokenInterceptorService
   */
  constructor(private injector: Injector) { }


  /**
   * Method for intercepting all http-requests before being executed. In this case responsible for
   * adding a JWT-token in the header. If there is no token, null is passed as token.
   *
   * @param request Original http-request.
   * @param next The request method to be executed after interception.
   * @returns
   */
  intercept(request: any, next: any) {
    const authService = this.injector.get(AuthService);
    const tokenizedRequest = request.clone({
      setHeaders: {
        Authorization: `Bearer ${authService.getToken()}`
      }
    });
    return next.handle(tokenizedRequest);
  }
}
