import {RouterModule, Routes} from "@angular/router";
import {ZwaveSensorsConfigurationComponent} from "./configuration/zwave.sensors.configuration.component";
import {ZwaveComponent} from "./zwave.component";
import {ZwaveSensorsComponent} from "./zwave.sensors.component";
import {ZwaveSensorConfigurationComponent} from "./configuration/zwave.sensor.configuration.component";

export const zwaveRoutes: Routes = [
  {
    path: 'zwave',
    component: ZwaveComponent,
    children: [
      {
        path: '',
        component: ZwaveSensorsComponent,
      }, {
        path: 'config',
        component: ZwaveSensorsConfigurationComponent,
        children: [
          {
            path: ':haId',
            component: ZwaveSensorConfigurationComponent
          }
        ]
      }
    ]
  }
];

export const ZwaveRouting = RouterModule.forChild(zwaveRoutes);
