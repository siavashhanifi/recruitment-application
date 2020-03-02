import { Injectable } from '@angular/core';
import { Application } from './enteties/application.entety';
import { getLocaleDateFormat } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

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
