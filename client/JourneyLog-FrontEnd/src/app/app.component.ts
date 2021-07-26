import { Component } from '@angular/core';
import { User } from './models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'JourneyLog-FrontEnd'

  loginUser? : User = {
    "userId" : 1,
    "firstName" : "Samuel",
    "lastName" :  "Sells",
    "email" : "SS@gmail.com"
  };
}
