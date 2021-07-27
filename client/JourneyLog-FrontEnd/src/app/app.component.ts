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

  loginUserId? : number

  loginUserAddressBook? : Location[] = []
  
  loginUserJourneyLog? : Journey[] = []

  loginUser?: User = new User (1, "Samuel", "Sells", "SS@gmail.com", "12345", [], []);
}
