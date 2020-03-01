import { Injectable } from '@angular/core';
import { Application } from './enteties/application.entety';
import { getLocaleDateFormat } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  private applicationsURL = 'api/content/applications';

  constructor(private http: HttpClient) { }


  public findAll(): Observable<Application[]> {
    return this.http.get<Application[]>(this.applicationsURL);
  }
  /*public findAll(): Observable<Application[]> {
    const application = this.http.get(this.applicationsURL).pipe(
      map((
        res => {
          return res['applications'];
        }
      )));
    return application;
  }*/
}
