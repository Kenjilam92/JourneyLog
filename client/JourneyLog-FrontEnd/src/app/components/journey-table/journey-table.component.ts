import {AfterViewInit, Component, ViewChild, OnInit} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {LocationToJourneyService} from '../../services/location-to-journey.service';

/*
Journey list with pagination, sort and select
*/

@Component({
  selector: 'app-journey-table',
  templateUrl: './journey-table.component.html',
  styleUrls: ['./journey-table.component.css']
})

export class JourneyTableComponent {

  displayedColumns: string[] = [
    'journeyId',
    'creatorId',
    'stopPoints',
    'time',
    'length'
  ];

  dataSource = new MatTableDataSource<JourneyElement>(DATA);
  clickedRows = new Set<JourneyElement>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
}

export interface JourneyElement {
  journeyId: number;
  creatorId: number;
  stopPoints: Location[];
  time: number;
  length: number;
}

export const DATA: JourneyElement[] = [
  {
    journeyId: 1,
    creatorId: 1,
    stopPoints : [],
    time: 922,
    length: 10923
    },
    {
    journeyId: 2,
    creatorId: 1,
    stopPoints : [],
    time: 418,
    length: 6500
    },
    {
    journeyId: 3,
    creatorId: 1,
    stopPoints : [],
    time: 250,
    length: 3420
    },
    {
    journeyId: 4,
    creatorId: 1,
    stopPoints : [],
    time: 103,
    length: 1403
    },
    {
    journeyId: 5,
    creatorId: 1,
    stopPoints : [],
    time: 83,
    length: 1109
    },
    {
    journeyId: 6,
    creatorId: 1,
    stopPoints : [],
    time: 10,
    length: 208
    },
    {
    journeyId: 7,
    creatorId: 1,
    stopPoints : [],
    time: 52,
    length: 789
    },
    {
    journeyId: 8,
    creatorId: 1,
    stopPoints : [],
    time: 33,
    length: 509
    },
    {
    journeyId: 9,
    creatorId: 1,
    stopPoints : [],
    time: 5,
    length: 122
    },
    {
    journeyId: 5,
    creatorId: 1,
    stopPoints : [],
    time: 1203,
    length: 23099
    }
];
