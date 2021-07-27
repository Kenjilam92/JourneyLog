import { Component, Input, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Location } from 'src/app/models/location';
import { Journey  } from 'src/app/models/journey';


@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  constructor() { }


  ngOnInit(): void {
    
  }
  @Input() loginUser? : User = new User(); 
  @Input() userId? : number = 0;
  @Input() addressBook? : Location[] = [];
  @Input() journeyLog? : Journey[] = []
}
