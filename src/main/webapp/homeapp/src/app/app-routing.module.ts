/**
 * Created by jorgma on 2017-07-06.
 */
import {Routes, RouterModule} from "@angular/router";
import {PageNotFoundComponent} from "./page-not-found.component";
import {EntryBoardComponent} from "./entry-board/entry-board.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {SlDepartureComponent} from "./sl/sl-departures/sl-departure.component";
import {StationsComponent} from "./sl/stations/stations.component";
import {WeatherComponent} from "./weather/weather.component";
import {NgModule} from "@angular/core";
import {WeatherConfigComponent} from "./weather/config/weather.config.component";

const appRoutes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'entry-board',
    component: EntryBoardComponent
  },
  {
    path: '',
    redirectTo: 'entry-board',
    pathMatch: 'full'
  },
  {path: '**', component: PageNotFoundComponent},
];

RouterModule.forRoot(appRoutes);

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule{}
