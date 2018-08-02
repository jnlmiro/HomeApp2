import {Component, OnInit} from '@angular/core';
import {WsService} from "../websocket/ws.service";
import {StompService} from "@stomp/ng2-stompjs";
import {ZwaveSensorService} from "./zwave.sensor.service";
import {Observable} from "rxjs/Observable";
import {ZwaveSensor} from "./zwave.sensor.model";

@Component({
  selector: 'zwave-sensors',
  styleUrls: ['zwave.sensors.component.scss'],
  templateUrl: 'zwave.sensors.component.html'
})
export class ZwaveSensorsComponent implements OnInit {
  title: string = "Home";
  msg: any = "";
  ws: StompService;
  wsSubscription: Observable<any>;
  sensors: ZwaveSensor[] = [];

  constructor(private wsService: WsService, private zwaveSensorService: ZwaveSensorService) {

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
        sensors.forEach(sensor => this.zwaveSensorService.addSensor(sensor));
        this.sensors = this.zwaveSensorService.sensors;
      });
  }

  listen(): void {
    this.wsSubscription
      .map((message: any) => {
        return message.body;
      })
      .subscribe(
        (msg_body: any) => {
          this.msg = msg_body;
          let sensor = this.zwaveSensorService.jsonToZwaveSensor(this.msg);
          this.zwaveSensorService.addSensor(sensor);
          this.sensors = this.zwaveSensorService.sensors;
        });
  }
}
