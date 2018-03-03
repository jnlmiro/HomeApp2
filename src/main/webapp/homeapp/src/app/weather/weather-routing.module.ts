import {RouterModule, Routes} from "@angular/router";
import {WeatherConfigComponent} from "./config/weather.config.component";
import {NgModule} from "@angular/core";
import {WeatherComponent} from "./weather.component";
import {WeatherForecast} from "./weather.model";
import {WeatherForecastComponent} from "./forecast/weather-forecast.component";

const weatherRoutes: Routes = [
  {
    path: 'weather',
    component: WeatherComponent,
    children: [
      {
        path: '',
        component: WeatherForecastComponent,
      }, {
        path: 'config',
        component: WeatherConfigComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(weatherRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class WeatherRoutingModule {
}
