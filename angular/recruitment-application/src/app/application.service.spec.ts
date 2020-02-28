import { TestBed } from '@angular/core/testing';

import { ApplicationServiceService } from './application.service';

describe('ApplicationServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApplicationServiceService = TestBed.get(ApplicationServiceService);
    expect(service).toBeTruthy();
  });
});
