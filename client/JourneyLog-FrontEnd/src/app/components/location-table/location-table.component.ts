import {AfterViewInit, Component, ViewChild, OnInit, Input} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import {LocationToJourneyService} from '../../services/location-to-journey.service';
import { Location } from '../../models/location'
/*
Address table with pagination, sort and select
*/

@Component({
  selector: 'app-location-table',
  templateUrl: './location-table.component.html',
  styleUrls: ['./location-table.component.css']
})

export class LocationTableComponent {


  constructor(private service: LocationToJourneyService) { }

  @Input()
  addressBook? : Location[] = [];

  displayedColumns: string[] = [
    'locationId',
    'streetNumber',
    'streetName',
    'city',
    'state',
    'zipcode',
  ];

  dataSource = new MatTableDataSource<Location>(this.addressBook);
  clickedRows = new Set<Location>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  selected() {
    this.service.add();
    console.log(this.clickedRows);
  }

}
