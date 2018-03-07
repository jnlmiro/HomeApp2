import {Component, OnInit} from '@angular/core';
import {WeatherLocation} from "../weather.model";
import {WeatherConfigService} from "./weather-config.service";

@Component({
  selector: 'weather-config-component',
  templateUrl: 'weather-config-component.component.html'
})

export class WeatherConfigComponent implements OnInit {

  foundLocations: WeatherLocation[] = [];
  constructor(private weatherConfigService: WeatherConfigService) {
  }

  ngOnInit() {
  }


  onSearch(searchString) {
    this.weatherConfigService.searchLocations(searchString)
      .subscribe(
        resultArray => this.foundLocations = resultArray,
        error => console.log("Error :: " + error)
      );
  }


  search(event) {
    let searchString:string =  event.target.value;
    this.onSearch(searchString);
  }

  locationViewValueFormatter = (x: {place: string}) => x.place;

}
