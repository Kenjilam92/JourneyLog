import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TestServicesComponent } from './components/test-services/test-services.component';
import { JourneyFormComponent } from './components/journey-form/journey-form.component';
import { LocationTableComponent } from './components/location-table/location-table.component';

@NgModule({
  declarations: [
    AppComponent,
    TestServicesComponent,
    JourneyFormComponent,
    LocationTableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
