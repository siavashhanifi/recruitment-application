import { Injectable } from '@angular/core';
import { Application } from './enteties/application.entety';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

/**
 * Class ApplicationService responsible for backend communication related to applications.
 *
 * @export
 */
@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  /**
   * applicationsURL: url for backend application handling
   */
  private applicationsURL = 'api/content/applications';

  constructor(private http: HttpClient) { }


  /**
   * Method for fetching all applications from backend server
   * @returns list of all applications as a JSON-object.
   */
  public findAll(): Observable<Application[]> {
    return this.http.get<Application[]>(this.applicationsURL);
  }
}
