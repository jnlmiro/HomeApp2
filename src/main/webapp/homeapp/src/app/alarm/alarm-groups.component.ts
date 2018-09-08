import {Component, OnInit} from '@angular/core';
import {AlarmGroupService} from "./alarm-group.service";
import {AlarmGroup} from "./alarm-group.model";

@Component({
  selector: 'alarm-groups',
  templateUrl: 'alarm-groups.component.html'
})
export class AlarmGroupsComponent implements OnInit {

  alarmGroups: AlarmGroup[] = [];

  constructor(private alarmGroupService: AlarmGroupService) {
  }

  ngOnInit() {
    this.getAlarmGroups();
  }

  private getAlarmGroups() {
    this.alarmGroupService.getAlarmGroups()
      .subscribe(alarmGroups => this.alarmGroups = alarmGroups);
  }


}
