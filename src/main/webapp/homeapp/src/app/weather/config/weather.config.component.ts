import {Component, OnInit} from '@angular/core';
import {WeatherLocation} from "../weather.model";

@Component({
  moduleId: module.id,
  selector: 'weather-config-component',
  templateUrl: 'weather-config-component.component.html'
})

export class WeatherConfigComponent implements OnInit {

  foundLocations: string[] = [];
  constructor() {
  }

  ngOnInit() {
  }


  onSearch(searchString) {
      this.foundLocations.push(searchString);
  }
}
