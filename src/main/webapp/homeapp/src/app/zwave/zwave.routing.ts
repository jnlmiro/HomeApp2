import {RouterModule, Routes} from "@angular/router";
import {ZwaveSensorsComponent} from "./zwave.sensors.component";

export const zwaveRoutes: Routes = [
  {
    path: 'zwave',
    component: ZwaveSensorsComponent,
  }

];

export const ZwaveRouting = RouterModule.forChild(zwaveRoutes);
