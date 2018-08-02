import {NgModule} from "@angular/core";
import {ZwaveSensorComponent} from "./zwave.sensor.component";
import {ZwaveRouting} from "./zwave.routing";
import {WsService} from "../websocket/ws.service";
import {StompService} from "@stomp/ng2-stompjs";
import {ZwaveSensorsComponent} from "./zwave.sensors.component";
import {ZwaveSensorService} from "./zwave.sensor.service";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  imports: [ZwaveRouting, CommonModule, HttpClientModule],
  declarations: [ZwaveSensorComponent, ZwaveSensorsComponent],
  exports: [],
  providers: [WsService, StompService, ZwaveSensorService]
})
export class ZwaveModule {
}
