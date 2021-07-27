import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/models/user';
import { ConnectBackEndService } from 'src/app/services/connect-back-end.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private backend : ConnectBackEndService) { }

  ngOnInit(): void {
  }
  
  @Output() loginUser = new EventEmitter<User>();

  login(form:NgForm){
    console.log(form.value);
    this.backend.login( form.controls['email'].value ,  form.controls['password'].value)
      .subscribe(e=>  {console.log(e); this.loginUser.emit(e)}
      , err => console.log(err) );
  }
  register(form:NgForm){
    console.log(form.value);
    this.backend.register(form.controls['firstName'].value,form.controls['lastName'].value, form.controls['email'].value, form.controls['password'].value)
      .subscribe( u => this.login(form), err => console.log(err) );
  }
}
