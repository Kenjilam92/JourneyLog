import { Component } from '@angular/core';
import { User } from './models/user';
import {Journey} from "./models/journey";
import { Location } from "./models/location";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor() {
  }

  title = 'JourneyLog'

  userId? : number


  loginUser?: User = new User();
  addressBook? : Location[] = [];
  journeyLog? : Journey[] = [];

  newUser( user : User){
    console.log(user);
    this.loginUser = user;
    this.addressBook = user.addressBook;
    this.journeyLog = user.journeyLog;
    this.userId = user.userId;
  }
}
