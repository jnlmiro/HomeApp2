import {NgModule} from "@angular/core";

import {BrowserModule} from "@angular/platform-browser";
import {StationsConfigurationComponent} from "./configuration/stations.configuration.component";
import {StationComponent} from "./station/station.component";
import {StationsService} from "./stations.service";
import {StationsRoutingModule} from "./stations-routing.module";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [BrowserModule, StationsRoutingModule, FormsModule],
  declarations: [StationsConfigurationComponent, StationComponent],
  providers: [StationsService]
})
export class StationsModule {
}
