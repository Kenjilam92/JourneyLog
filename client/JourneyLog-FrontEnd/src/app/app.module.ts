
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatCardModule } from '@angular/material/card';
import { MatExpansionModule } from '@angular/material/expansion';


import { AppComponent } from './app.component';
import { TestServicesComponent } from './components/test-services/test-services.component';
import { JourneyFormComponent } from './components/journey-form/journey-form.component';
import { HeaderComponent } from './components/header/header.component';
import { MetterToMilesPipe } from './pipes/metter-to-miles.pipe';
import { SecondsToTimeStringPipe } from './pipes/seconds-to-time-string.pipe';

import { LocationTableComponent } from './components/location-table/location-table.component';
import { JourneyTableComponent } from './components/journey-table/journey-table.component';
import { TableTabsComponent } from './components/table-tabs/table-tabs.component';

@NgModule({
  declarations: [
    AppComponent,
    TestServicesComponent,
    JourneyFormComponent,
    MetterToMilesPipe,
    SecondsToTimeStringPipe,
    HeaderComponent,
    LocationTableComponent,
    JourneyTableComponent,
    TableTabsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatTabsModule,
    MatPaginatorModule,
    MatSortModule,
    MatCardModule,
    MatExpansionModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
