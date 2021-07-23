import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ConnectBackEndService {

  private domain : string = "http://localhost:9090/JourneyLog/api";
  
  constructor(private http : HttpClient) { }
  
  login( email : string, password : string ) : Observable<User>{
  const json = {
    "email" : email,
    "password" : password
  }

    return this.http.post<User>(`${this.domain}/login/user`,json);
  }

  register( email : string, password : string , firstName : string , lastName : string ) : Observable<any> {
    const json = {
      "email" : email,
      "password" : password,
      "firstName" : firstName,
      "lastName" : lastName
    }
    return this.http.post(`${this.domain}/create/users`, json);
  }

  addLocation( streetNumber : number, streetName : string, city : string , state : string , zipcode : string ) : Observable<any> {
    console.log("addLocation to backend");

    const json = {
      "streetNumber" : streetNumber,
      "streetName" : streetName,
      "city" : city,
      "state" : state,
      "zipcode" : zipcode
    };
    return this.http.post(`${this.domain}/create/locations`, json);
  }

  addJourney( creatorId : number, time : number , length : number, stopPoints : Location[] ) : Observable<any> {
    const json = {
      "creatorId" : creatorId,
      "time" : time,
      "length" : length,
      "stopPonts" : stopPoints
    };
    return this.http.post ( `${this.domain}/create/journeys`,json);    
  }  
}

