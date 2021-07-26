import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { LocationTableComponent } from '../location-table/location-table.component';
import { LocationToJourneyService } from '../../services/location-to-journey.service';
import { Subscription } from 'rxjs';

/*
Journey list
*/

@Component({
  selector: 'app-journey-table',
  templateUrl: './journey-table.component.html',
  styleUrls: ['./journey-table.component.css']
})

export class JourneyTableComponent {

  constructor() { }

}
