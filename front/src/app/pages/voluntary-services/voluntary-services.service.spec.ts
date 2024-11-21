import { TestBed } from '@angular/core/testing';
import { VoluntaryServicesService } from './voluntary-services.service';


describe('VoluntaryServicesService', () => {
  let service: VoluntaryServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VoluntaryServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
