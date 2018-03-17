import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {PageNotFoundComponent} from "./page-not-found.component";
import {EntryBoardModule} from "./entry-board/entry-board.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {DashboardModule} from "./dashboard/dashboard.module";
import {RPiBacklightModule} from "./rpi-backlight/rpi-backlight.module";
import {StationsModule} from "./sl/stations/stations.module";
import {AppRoutingModule} from "./app-routing.module";
import {WeatherModule} from "./weather/weather.module";
import {HttpClientModule} from "@angular/common/http";
import {SharedModule} from "./shared/shared.module";

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    EntryBoardModule,
    DashboardModule,
    RPiBacklightModule,
    StationsModule,
    WeatherModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
