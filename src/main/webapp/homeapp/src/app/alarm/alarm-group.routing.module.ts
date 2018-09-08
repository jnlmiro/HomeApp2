import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {AlarmGroupsComponent} from "./alarm-groups.component";

const alarmGroupRoutes: Routes = [
  {
    path: 'alarm-groups',
    component: AlarmGroupsComponent,
  }

];

@NgModule({
  imports: [
    RouterModule.forChild(alarmGroupRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AlarmGroupRoutingModule {
}
