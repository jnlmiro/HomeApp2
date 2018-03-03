import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {StationsComponent} from "./stations.component";

const stationsRoutes: Routes = [
  {
    path: 'stations',
    component: StationsComponent,
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
