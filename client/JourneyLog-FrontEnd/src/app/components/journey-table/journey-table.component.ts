import {AfterViewInit, Component, Input, ViewChild} from '@angular/core';
import { LocationTableComponent } from '../location-table/location-table.component';
import { LocationToJourneyService } from '../../services/location-to-journey.service';
import { Subscription } from 'rxjs';
import { Journey } from 'src/app/models/journey';
import { Location } from 'src/app/models/location';

import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
/*
Journey list with pagination, sort and select
*/

@Component({
  selector: 'app-journey-table',
  templateUrl: './journey-table.component.html',
  styleUrls: ['./journey-table.component.css']
})

export class JourneyTableComponent {
  panelOpenState = false;
  constructor() { }
  @Input()
  journeyLog?: Journey[] = [];

  displayedColumns: string[] = [
    'journeyId',
    'stop points',
    'time',
    'length'
  ];

  dataSource = new MatTableDataSource<Journey>(this.journeyLog);
  clickedRows = new Set<Journey>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

}
