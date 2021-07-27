import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LocationToJourneyService {

  constructor() { }

  add() /*: Observable<AddressElement[]>*/ {

    console.log("Add selected to Journey");
  }
}
