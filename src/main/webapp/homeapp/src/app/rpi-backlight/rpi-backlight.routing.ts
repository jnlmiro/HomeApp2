/**
 * Created by jorgma on 2017-07-06.
 */
import {Routes, RouterModule} from "@angular/router";
import {RPiBacklightComponent} from "./rpi-backlignt.component";


export const routes: Routes = [
  {path: 'rpi-backlight', component: RPiBacklightComponent},
];

export const RPiBacklightRouting = RouterModule.forChild(routes);
