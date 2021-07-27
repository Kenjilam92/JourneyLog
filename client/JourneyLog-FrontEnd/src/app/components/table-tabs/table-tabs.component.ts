import { Component, Input, OnInit } from '@angular/core';
import { Journey } from 'src/app/models/journey';
import { Location } from 'src/app/models/location';

@Component({
  selector: 'app-table-tabs',
  templateUrl: './table-tabs.component.html',
  styleUrls: ['./table-tabs.component.css']
})
export class TableTabsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  @Input()journeysList? : Journey[] =[];
  
  @Input()locationsList? : Location[] = [];
}
