import { Injectable } from '@angular/core';
import { Application } from './enteties/application.entety';
import { getLocaleDateFormat } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  constructor() { }

  findAll(): Application[] {
    return [
      {
        applicantName: 'Sebastian',
        applicantSsn: 123456,
        availability: [
          {
            fromDate: new Date(2020, 6, 15),
            toDate: new Date(2020, 8, 20)
          },
          {
            fromDate: new Date(2021, 1, 25),
            toDate: new Date(2021, 4, 15)
          }
        ],
        competenceProfile: {
            competence: [
              {name: 'it'},
              {name: 'cooking'}
            ],
            yearsOfExperience: 31
          }
      },

      {
        applicantName: 'Sia',
        applicantSsn: 234567,
        availability: [
          {
            fromDate: new Date(2020, 6, 15),
            toDate: new Date(2020, 8, 20)
          },
          {
            fromDate: new Date(2021, 1, 25),
            toDate: new Date(2021, 4, 15)
          }
        ],
        competenceProfile: {
            competence: [
              {name: 'dancing'},
              {name: 'singing'}
            ],
            yearsOfExperience: 25
          }
      },

      {
        applicantName: 'Björn',
        applicantSsn: 345678,
        availability: [
          {
            fromDate: new Date(2020, 6, 15),
            toDate: new Date(2020, 8, 20)
          },
          {
            fromDate: new Date(2021, 1, 25),
            toDate: new Date(2021, 4, 15)
          }
        ],
        competenceProfile: {
            competence: [
              {name: 'rollercoasters'},
              {name: 'popcorn'}
            ],
            yearsOfExperience: 49
          }
      }
    ];
  }
}
