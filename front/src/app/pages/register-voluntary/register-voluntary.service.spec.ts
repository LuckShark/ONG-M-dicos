import { TestBed } from '@angular/core/testing';

import { RegisterVoluntaryService } from './register-voluntary.service';

describe('RegisterVoluntaryService', () => {
  let service: RegisterVoluntaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterVoluntaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
