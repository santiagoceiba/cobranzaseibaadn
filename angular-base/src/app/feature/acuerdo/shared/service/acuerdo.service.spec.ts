import { TestBed } from '@angular/core/testing';

import { AcuerdoService } from './acuerdo.service';

describe('AcuerdoService', () => {
  let service: AcuerdoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AcuerdoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
