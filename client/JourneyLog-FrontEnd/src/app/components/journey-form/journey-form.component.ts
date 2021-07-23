import { Component, OnInit } from '@angular/core';
import { GoogleAPIService } from 'src/app/services/google-api.service';
import { Location } from '../../models/location';

@Component({
  selector: 'app-journey-form',
  templateUrl: './journey-form.component.html',
  styleUrls: ['./journey-form.component.css']
})
export class JourneyFormComponent implements OnInit {

  constructor( private googleMap : GoogleAPIService ) { }

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


  ngOnInit(): void {
  }

  estimateClick( ...a : any ){
    const start : Location = new Location(0, this.streetNumberStart, this.streetNameStart, this.cityStart, this.stateStart, this.zipcodeStart);
    const end : Location = new Location(0, this.streetNumberEnd, this.streetNameEnd, this.cityEnd, this.stateEnd, this.zipcodeEnd);

    console.log(start, end);
    this.googleMap.getAPI(start,end)
      .subscribe(x => console.log(x), err=> console.log(err), () => console.log('function not run at all') );
  }

  saveJourneyClick(...a: any ){
    console.log(a);
  }
}
