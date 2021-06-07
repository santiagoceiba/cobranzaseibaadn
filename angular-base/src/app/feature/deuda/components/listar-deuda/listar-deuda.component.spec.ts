import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarDeudaComponent } from './listar-deuda.component';

describe('ListarDeudaComponent', () => {
  let component: ListarDeudaComponent;
  let fixture: ComponentFixture<ListarDeudaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarDeudaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarDeudaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
