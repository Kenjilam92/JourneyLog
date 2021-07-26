import { Component, Input, OnInit } from '@angular/core';
import { User } from '../../models/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input()
  userData: User = {
    "userId" : 0,
    "firstName" : "FirstName",
    "lastName" :  "LastName",
    "email" : "email@website.com"
  };
}
