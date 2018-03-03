import {NgModule} from "@angular/core";

import {BrowserModule} from "@angular/platform-browser";
import {StationsComponent} from "./stations.component";
import {StationComponent} from "./station/station.component";
import {StationsService} from "./stations.service";
import {StationsRoutingModule} from "./stations-routing.module";

@NgModule({
  imports: [BrowserModule, StationsRoutingModule],
  declarations: [StationsComponent, StationComponent],
  providers: [StationsService]
})
export class StationsModule {
}
