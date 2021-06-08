import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CerrarAcuerdosPagosComponent } from './cerrar-acuerdos-pagos.component';

describe('CerrarAcuerdosPagosComponent', () => {
  let component: CerrarAcuerdosPagosComponent;
  let fixture: ComponentFixture<CerrarAcuerdosPagosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CerrarAcuerdosPagosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CerrarAcuerdosPagosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
