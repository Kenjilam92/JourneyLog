import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ConnectBackEndService } from 'src/app/services/connect-back-end.service';
import { GoogleAPIService } from 'src/app/services/google-api.service';
import { Location } from '../../models/location';

@Component({
  selector: 'app-journey-form',
  templateUrl: './journey-form.component.html',
  styleUrls: ['./journey-form.component.css']
})
export class JourneyFormComponent implements OnInit {

  constructor( private googleMap : GoogleAPIService,
    private backend : ConnectBackEndService
  ) { }

  streetNumberStart : number = 0;
  streetNameStart : string = '';
  cityStart : string = '';
  stateStart : string = '';
  zipcodeStart : string = '';

  streetNumberEnd : number = 0;
  streetNameEnd : string = '';
  cityEnd : string = '';
  stateEnd : string = '';
  zipcodeEnd : string = '';
  
  length : number = 0;
  time : number = 0;

  @Input() creatorId : number = 0;

  start : Location = new Location();
  end : Location = new Location(); 

  ngOnInit(): void {
  }

  estimateClick( ...a : any ){
    
    this.start = new Location(0, this.streetNumberStart, this.streetNameStart, this.cityStart, this.stateStart, this.zipcodeStart);
    this.end = new Location(0, this.streetNumberEnd, this.streetNameEnd, this.cityEnd, this.stateEnd, this.zipcodeEnd);
    
    this.googleMap.getAPI(this.start,this.end)
      .subscribe(x => {
        
        this.length = x.routes[0].legs[0].distance.value;
        this.time = x.routes[0].legs[0].duration.value;
      }
      , err=> console.log(err));
  }

  saveJourneyClick(...a: any ){
    console.log(a);
    this.start = new Location(0, this.streetNumberStart, this.streetNameStart, this.cityStart, this.stateStart, this.zipcodeStart);
    this.end = new Location(0, this.streetNumberEnd, this.streetNameEnd, this.cityEnd, this.stateEnd, this.zipcodeEnd);
    
    this.googleMap.getAPI(this.start,this.end)
      .subscribe(x => {
        
        this.length = x.routes[0].legs[0].distance.value;
        this.time = x.routes[0].legs[0].duration.value;
        const stopPoints : Location[] = [this.start , this.end];
        this.backend.addJourney(this.creatorId, this.time , this.length, stopPoints)
        .subscribe(x => {
          console.log(x);
        }
        , err=> console.log(err));
      }
      , err=> console.log(err));
   
   

  }
}
