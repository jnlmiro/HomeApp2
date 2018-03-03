/**
 * Created by jorgma on 2017-07-06.
 */
import {NgModule} from "@angular/core";
import {SlDepartureComponent} from "./sl-departures/sl-departure.component";
import {HttpModule} from "@angular/http";
import {SlDepartureService} from "./sl-departures/sl-departure.service";
import {BrowserModule} from "@angular/platform-browser";
import {DeparturesFilter} from "./departuresFilter";
import {SlComponent} from "./sl.component";


@NgModule({
  imports: [HttpModule, BrowserModule],
  exports: [SlDepartureComponent],
  declarations: [SlDepartureComponent, DeparturesFilter, SlComponent],
  providers: [SlDepartureService],
})
export class SlDepartureModule {
}
