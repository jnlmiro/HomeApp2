import {NgModule} from "@angular/core";
import {ZwaveSensorComponent} from "./zwave.sensor.component";
import {ZwaveRouting} from "./zwave.routing";
import {WsService} from "../websocket/ws.service";
import {StompService} from "@stomp/ng2-stompjs";
import {ZwaveSensorsComponent} from "./zwave.sensors.component";
import {ZwaveSensorService} from "./zwave.sensor.service";
import {CommonModule} from "@angular/common";


@NgModule({
  imports: [ZwaveRouting, CommonModule],
  declarations: [ZwaveSensorComponent, ZwaveSensorsComponent],
  exports: [],
  providers: [WsService, StompService, ZwaveSensorService]
})
export class ZwaveModule {
}
