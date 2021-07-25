import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';

/*
Address table with pagination, sort and select
*/

@Component({
  selector: 'app-location-table',
  templateUrl: './location-table.component.html',
  styleUrls: ['./location-table.component.css']
})

export class LocationTableComponent {
  displayedColumns: string[] = [
    'locationId',
    'streetNumber',
    'streetName',
    'city',
    'state',
    'zipcode',
  ];
  dataSource = new MatTableDataSource<AddressElement>(DATA);
  clickedRows = new Set<AddressElement>();

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
}

export interface AddressElement {
  locationId: number;
  streetNumber: number;
  streetName: string;
  city: string;
  state: string;
  zipcode: string;
}

const DATA: AddressElement[] = [
    {
      locationId: 1,
      streetNumber: 5,
      streetName: "Maryland",
      city: "Saginaw",
      state: "Michigan",
      zipcode: "11902"
    },
    {
      locationId: 2,
      streetNumber: 3,
      streetName: "Tennessee",
      city: "Atlanta",
      state: "Georgia",
      zipcode: "19484"
    },
    {
      locationId: 3,
      streetNumber: 2,
      streetName: "Bashford",
      city: "Houston",
      state: "Texas",
      zipcode: "16268"
    },
    {
      locationId: 4,
      streetNumber: 192,
      streetName: "Montana",
      city: "Berkeley",
      state: "California",
      zipcode: "16913"
    },
    {
      locationId: 5,
      streetNumber: 826,
      streetName: "Elka",
      city: "Washington",
      state: "District of Columbia",
      zipcode: "15130"
    },
    {
      locationId: 6,
      streetNumber: 92,
      streetName: "5th",
      city: "Houston",
      state: "Texas",
      zipcode: "17781"
    },
    {
      locationId: 7,
      streetNumber: 953,
      streetName: "Anzinger",
      city: "Flint",
      state: "Michigan",
      zipcode: "15194"
    },
    {
      locationId: 8,
      streetNumber: 64,
      streetName: "Gulseth",
      city: "Bloomington",
      state: "Indiana",
      zipcode: "17767"
    },
    {
      locationId: 9,
      streetNumber: 16355,
      streetName: "Dottie",
      city: "Kansas City",
      state: "Missouri",
      zipcode: "15180"
    },
    {
      locationId: 10,
      streetNumber: 8,
      streetName: "Cordelia",
      city: "Oakland",
      state: "California",
      zipcode: "13821"
    },
    {
      locationId: 11,
      streetNumber: 173,
      streetName: "Blaine",
      city: "El Paso",
      state: "Texas",
      zipcode: "15167"
    },
    {
      locationId: 12,
      streetNumber: 2429,
      streetName: "Sage",
      city: "Port Charlotte",
      state: "Florida",
      zipcode: "18190"
    },
    {
      locationId: 13,
      streetNumber: 5945,
      streetName: "Schiller",
      city: "Athens",
      state: "Georgia",
      zipcode: "18552"
    },
    {
      locationId: 14,
      streetNumber: 15899,
      streetName: "Crescent Oaks",
      city: "Henderson",
      state: "Nevada",
      zipcode: "14979"
    },
    {
      locationId: 15,
      streetNumber: 28,
      streetName: "Lakewood Gardens",
      city: "New Orleans",
      state: "Louisiana",
      zipcode: "19172"
    },
    {
      locationId: 16,
      streetNumber: 3,
      streetName: "Bluestem",
      city: "Kansas City",
      state: "Missouri",
      zipcode: "11165"
    },
    {
      locationId: 17,
      streetNumber: 476,
      streetName: "Green",
      city: "Monticello",
      state: "Minnesota",
      zipcode: "19582"
    },
    {
      locationId: 18,
      streetNumber: 81,
      streetName: "Reindahl",
      city: "Albany",
      state: "New York",
      zipcode: "14387"
    },
    {
      locationId: 19,
      streetNumber: 73,
      streetName: "Dunning",
      city: "Fort Worth",
      state: "Texas",
      zipcode: "11322"
    },
    {
      locationId: 20,
      streetNumber: 8602,
      streetName: "Utah",
      city: "Austin",
      state: "Texas",
      zipcode: "12886"
    }
];
