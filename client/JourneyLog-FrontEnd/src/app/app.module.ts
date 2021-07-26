import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { TestServicesComponent } from './components/test-services/test-services.component';
import { JourneyFormComponent } from './components/journey-form/journey-form.component';
import { MetterToMilesPipe } from './pipes/metter-to-miles.pipe';
import { SecondsToTimeStringPipe } from './pipes/seconds-to-time-string.pipe';

@NgModule({
  declarations: [
    AppComponent,
    TestServicesComponent,
    JourneyFormComponent,
    MetterToMilesPipe,
    SecondsToTimeStringPipe
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
