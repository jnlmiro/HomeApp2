import {NgModule} from "@angular/core";
import {ZwaveSensorComponent} from "./zwave.sensor.component";
import {ZwaveRouting} from "./zwave.routing";
import {ZwaveSensorsComponent} from "./zwave.sensors.component";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  imports: [ZwaveRouting, CommonModule, HttpClientModule],
  declarations: [ZwaveSensorComponent, ZwaveSensorsComponent],
  exports: [],
  providers: []
})
export class ZwaveModule {
}
