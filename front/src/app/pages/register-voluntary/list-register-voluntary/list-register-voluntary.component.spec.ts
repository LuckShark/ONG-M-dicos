import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListRegisterVoluntaryComponent } from './list-register-voluntary.component';

describe('ListRegisterVoluntaryComponent', () => {
  let component: ListRegisterVoluntaryComponent;
  let fixture: ComponentFixture<ListRegisterVoluntaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListRegisterVoluntaryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListRegisterVoluntaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
