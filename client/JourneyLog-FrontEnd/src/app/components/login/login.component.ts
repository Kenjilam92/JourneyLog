import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Output() login = new EventEmitter<NgForm>();

  onSubmit(form: NgForm){
    console.log(form.value);
    this.login.emit(form);
  }
}
