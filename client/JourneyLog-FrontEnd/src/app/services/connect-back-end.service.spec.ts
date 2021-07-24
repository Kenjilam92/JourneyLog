import { TestBed } from '@angular/core/testing';

import { ConnectBackEndService } from './connect-back-end.service';

describe('ConnectBackEndService', () => {
  let service: ConnectBackEndService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnectBackEndService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
