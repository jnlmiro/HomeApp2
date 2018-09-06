import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {StationsConfigurationComponent} from "./configuration/stations.configuration.component";

const stationsRoutes: Routes = [
  {
    path: 'stations',
    component: StationsConfigurationComponent,
  }

];

@NgModule({
  imports: [
    RouterModule.forChild(stationsRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class StationsRoutingModule {
}
