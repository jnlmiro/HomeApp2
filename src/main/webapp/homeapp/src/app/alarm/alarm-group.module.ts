import {NgModule} from '@angular/core';
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";
import {AlarmGroupRoutingModule} from "./alarm-group.routing.module";
import {AlarmGroupsComponent} from "./alarm-groups.component";
import {AlarmGroupComponent} from "./alarm-group.component";
import {AlarmGroupService} from "./alarm-group.service";

@NgModule({
  imports: [BrowserModule, FormsModule, AlarmGroupRoutingModule],
  declarations: [AlarmGroupComponent, AlarmGroupsComponent],
  providers: [AlarmGroupService],
})
export class AlarmGroupModule {
}
