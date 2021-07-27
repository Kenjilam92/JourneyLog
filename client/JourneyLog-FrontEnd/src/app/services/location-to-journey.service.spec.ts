import { TestBed } from '@angular/core/testing';

import { LocationToJourneyService } from './location-to-journey.service';

describe('LocationToJourneyService', () => {
  let service: LocationToJourneyService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LocationToJourneyService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
