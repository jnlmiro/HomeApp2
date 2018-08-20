import {NgModule} from "@angular/core";
import {ZwaveSensorComponent} from "./zwave.sensor.component";
import {ZwaveRouting} from "./zwave.routing";
import {ZwaveSensorsComponent} from "./zwave.sensors.component";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {PincodeModule} from "../shared/pincode/pincode.module";


@NgModule({
  imports: [ZwaveRouting, CommonModule, HttpClientModule, PincodeModule],
  declarations: [ZwaveSensorComponent, ZwaveSensorsComponent],
  exports: [],
  providers: []
})
export class ZwaveModule {
}
