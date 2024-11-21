import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRegisterVoluntaryComponent } from './form-register-voluntary.component';

describe('FormRegisterVoluntaryComponent', () => {
  let component: FormRegisterVoluntaryComponent;
  let fixture: ComponentFixture<FormRegisterVoluntaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormRegisterVoluntaryComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormRegisterVoluntaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
