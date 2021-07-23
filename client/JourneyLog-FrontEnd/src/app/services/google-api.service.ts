import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Location } from '../models/location';

@Injectable({
  providedIn: 'root'
})
export class GoogleAPIService {
  private domain: string = "https://maps.googleapis.com/maps/api/directions/json";
  private key: string = "key=AIzaSyBYb__QbEXCobFa5QRKJODTVxkpK0Qw17w";
  

  constructor( private http : HttpClient ) {
    
  }

  getAPI( start : Location, end: Location ) : Observable<any> {
    let origin = `origin=${start.streetNumber}+${start.streetName}+${start.city}+${start.state}+${start.zipcode}`
    let destination = `destination=${end.streetNumber}+${end.streetName}+${end.city}+${end.state}+${end.zipcode}` 
    origin = origin.replace(" ","+");
    destination = destination.replace(" ","+");
    const url = `${this.domain}?${origin}&${destination}&${this.key}`;
    console.log(url);
    return this.http.get(url);
  }
}
