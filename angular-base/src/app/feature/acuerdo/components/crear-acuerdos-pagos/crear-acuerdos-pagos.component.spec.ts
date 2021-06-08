import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearAcuerdosPagosComponent } from './crear-acuerdos-pagos.component';

describe('CrearAcuerdosPagosComponent', () => {
  let component: CrearAcuerdosPagosComponent;
  let fixture: ComponentFixture<CrearAcuerdosPagosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearAcuerdosPagosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearAcuerdosPagosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
