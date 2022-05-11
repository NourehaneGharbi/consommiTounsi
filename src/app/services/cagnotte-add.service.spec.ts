import { TestBed } from '@angular/core/testing';

import { CagnotteAddService } from './cagnotte-add.service';

describe('CagnotteAddService', () => {
  let service: CagnotteAddService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CagnotteAddService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
