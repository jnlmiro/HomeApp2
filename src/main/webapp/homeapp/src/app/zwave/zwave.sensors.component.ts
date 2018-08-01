import {Component, OnInit} from '@angular/core';
import {WsService} from "../websocket/ws.service";
import {StompService} from "@stomp/ng2-stompjs";
import {ZwaveSensorService} from "./zwave.sensor.service";
import {Observable} from "rxjs/Observable";
import {ZwaveSensor} from "./zwave.sensor.model";

@Component({
  selector: 'zwave-sensors',
  templateUrl: 'zwave.sensors.component.html'
})
export class ZwaveSensorsComponent implements OnInit {
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
  }

  listen(): void {
    this.wsSubscription
      .map((message: any) => {
        return message.body;
      })
      .subscribe(
        (msg_body: any) => {
          console.log(`Received: ${msg_body}`);
          this.msg = msg_body;
          let sensor = this.zwaveSensorService.jsonToZwaveSensor(this.msg);
          console.log(sensor);
          this.zwaveSensorService.addSensor(sensor);
          this.sensors = this.zwaveSensorService.sensors;
        });
  }
}
