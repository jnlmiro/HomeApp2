import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {AlarmGroup} from "./alarm-group.model";

@Injectable()
export class AlarmGroupService {

  private url:string = "/api/alarm-groups";

  constructor(private httpClient:HttpClient) {
  }

  getAlarmGroups():Observable<AlarmGroup[]> {
    return this.httpClient.get<AlarmGroup[]>(this.url)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));  }


  createAlarmGroup(alarmGroup:AlarmGroup):Observable<AlarmGroup> {
    return this.httpClient.post<AlarmGroup>(this.url, alarmGroup)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));  }

  updateAlarmGroup(alarmGroup:AlarmGroup):Observable<AlarmGroup> {
    return this.httpClient.put<AlarmGroup>(`${this.url}/${alarmGroup.id}`, alarmGroup)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }
}
