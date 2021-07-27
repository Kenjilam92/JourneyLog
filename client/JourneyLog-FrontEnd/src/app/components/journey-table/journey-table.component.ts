import {AfterViewInit, Component, ViewChild} from '@angular/core';
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
  panelOpenState = false;
  constructor() { }

}
