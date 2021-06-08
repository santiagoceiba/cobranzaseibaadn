import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarAcuerdosComponent } from './listar-acuerdos.component';

describe('ListarAcuerdosComponent', () => {
  let component: ListarAcuerdosComponent;
  let fixture: ComponentFixture<ListarAcuerdosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarAcuerdosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarAcuerdosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
