import { Component, OnInit, Input } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-address-form',
  templateUrl: './address-form.component.html',
  styleUrls: ['./address-form.component.css']
})
export class AddressFormComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  @Input()  creatorId? : number = 0
  
  
  onSubmit( form: NgForm ) {
    console.log(JSON.stringify(form.value));
  }
}
