import { TestBed } from '@angular/core/testing';

import { VolunteerworkService } from './volunteerwork.service';

describe('VolunteerworkService', () => {
  let service: VolunteerworkService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VolunteerworkService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
