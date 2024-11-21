import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoluntaryServicesComponent } from './voluntary-services.component';

describe('VoluntaryServicesComponent', () => {
  let component: VoluntaryServicesComponent;
  let fixture: ComponentFixture<VoluntaryServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VoluntaryServicesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VoluntaryServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
