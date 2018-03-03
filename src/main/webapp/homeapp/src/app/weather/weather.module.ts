/**
 * Created by jorgma on 2017-07-09.
 */
import {NgModule} from "@angular/core";
import {WeatherComponent} from "./weather.component";
import {WeatherService} from "./weather.service";
import {TimeSeriesComponent} from "./timeseries/timeseries.component";
import {CurrentWeatherComponent} from "./current-weather/current-weather.component";
import {BrowserModule} from "@angular/platform-browser";
import {CurrentWeatherTimeseriesFilter} from "./currentWeatherTimeSeriesFilter";
import {WeatherConfigComponent} from "./config/weather.config.component";
import {WeatherRoutingModule} from "./weather-routing.module";
import {WeatherForecastComponent} from "./forecast/weather-forecast.component";
import {SharedModule} from "../shared/shared.module";
import {WeatherConfigService} from "./config/weather-config.service";


@NgModule({
  imports: [BrowserModule, WeatherRoutingModule, SharedModule],
  exports: [WeatherForecastComponent],
  declarations: [WeatherComponent, WeatherForecastComponent, TimeSeriesComponent, CurrentWeatherComponent, CurrentWeatherTimeseriesFilter, WeatherConfigComponent],
  providers: [WeatherService, WeatherConfigService],
})
export class WeatherModule {
}
