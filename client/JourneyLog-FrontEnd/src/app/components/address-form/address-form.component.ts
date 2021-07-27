import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-address-form',
  templateUrl: './address-form.component.html',
  styleUrls: ['./address-form.component.css']
})
export class AddressFormComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  @Input()
  userId? : number = 0
    
}
