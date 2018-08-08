import {Component, OnInit} from '@angular/core';
import {ZwaveSensorService} from "./zwave/zwave.sensor.service";
import {WsService} from "./websocket/ws.service";
import {StompService} from "@stomp/ng2-stompjs";
import {Observable} from "rxjs/Observable";
import {ZwaveSensor} from "./zwave/zwave.sensor.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  ws: StompService;
  wsSubscription: Observable<any>;

  constructor(private wsService: WsService, private zwaveSensorService: ZwaveSensorService, private router: Router) {

  }

  ngOnInit() {
    this.ws = this.wsService.getWs();
    this.wsSubscription = this.ws.subscribe('/topic');
    this.listen();
    this.getSensors();
  }

  getSensors() {
    this.zwaveSensorService.getSensors()
      .subscribe(sensors => {
        sensors.forEach(sensor => {
          console.log(`Alarming sensor: ${sensor}`);
          if (this.alarmDetected(sensor)) {
            this.navigateToAlarm(sensor);
          }
        });
      });
  }

  alarmDetected(sensor: ZwaveSensor): void {
    if (sensor.alarming) {
      this.navigateToAlarm(sensor);
    }
  }

  listen(): void {
    this.wsSubscription
      .map((message: any) => {
        return message.body;
      })
      .subscribe(
        (msg: any) => {
          let sensor = this.zwaveSensorService.jsonToZwaveSensor(msg);
          if (this.alarmDetected(sensor)) {
            console.log(`Alarming sensor: ${sensor}`);
            this.navigateToAlarm(sensor);
          }
        });
  }

  navigateToAlarm(sensor: ZwaveSensor) {
    this.router.navigate(['/zwave']);
  }
}
