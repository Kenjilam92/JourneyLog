import { Component, OnInit } from '@angular/core';
import { ConnectBackEndService } from 'src/app/services/connect-back-end.service';

@Component({
  selector: 'app-test-services',
  templateUrl: './test-services.component.html',
  styleUrls: ['./test-services.component.css']
})
export class TestServicesComponent implements OnInit {

  constructor(
    private backend : ConnectBackEndService
  ) { }

  streetNumber : number = 0;
  streetName : string = '';
  city : string = '';
  state : string = '';
  zipcode : string = '';


  locationFormSubmit( ...a:any ){
    console.log(a);
    console.log (this.streetNumber);
    if (this.streetNumber > 0 && this.streetName !=='' && this.city !=='' && this.state !=='' && this.zipcode !=='' ){
      this.backend.addLocation( this.streetNumber, this.streetName, this.city, this.state, this.zipcode)
        .subscribe( x => console.log(x) , err => console.log (err), () => console.log('observe not complete') );
    }
    else {
      console.log("do not run backend function");
    }
  }


  

  ngOnInit(): void { 
    console.log("start when render component");  
  }

}
