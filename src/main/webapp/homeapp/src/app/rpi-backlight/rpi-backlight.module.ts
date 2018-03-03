/**
 * Created by jorgma on 2017-08-09.
 */
import {NgModule} from "@angular/core";
import {RPiBacklightComponent} from "./rpi-backlignt.component";
import {RPiBacklightRouting} from "./rpi-backlight.routing";


@NgModule({
  imports: [RPiBacklightRouting],
  exports: [],
  declarations: [RPiBacklightComponent],
  providers: [],
})
export class RPiBacklightModule {
}
