import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BorrarDeudaComponent } from './borrar-deuda.component';

describe('BorrarDeudaComponent', () => {
  let component: BorrarDeudaComponent;
  let fixture: ComponentFixture<BorrarDeudaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BorrarDeudaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BorrarDeudaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
