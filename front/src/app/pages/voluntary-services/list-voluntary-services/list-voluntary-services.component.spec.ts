import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListVoluntaryServicesComponent } from './list-voluntary-services.component';

describe('ListVoluntaryServicesComponent', () => {
  let component: ListVoluntaryServicesComponent;
  let fixture: ComponentFixture<ListVoluntaryServicesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListVoluntaryServicesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListVoluntaryServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
