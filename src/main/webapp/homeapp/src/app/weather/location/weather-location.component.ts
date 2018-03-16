import {Component, OnInit} from '@angular/core';
import {WeatherLocation} from "../weather.model";
import {WeatherLocationService} from "./weather-location.service";

@Component({
  selector: 'weather-location-component',
  templateUrl: 'weather-location.component.html'
})

export class WeatherLocationComponent implements OnInit {

  private foundLocations: WeatherLocation[] = [];
  private selectedLocation: WeatherLocation = null;
  private locations: WeatherLocation[] = [];

  constructor(private weatherLocationService: WeatherLocationService) {
  }

  ngOnInit() {
    this.getAllLocations();
  }

  getAllLocations() {
    this.weatherLocationService.getAllLocations()
      .subscribe(
        locations => this.locations = locations,
        () => {
        }
      )
  }

  onSearch(searchString) {
    this.weatherLocationService.searchLocations(searchString)
      .subscribe(
        foundLocations => this.foundLocations = foundLocations,
        () => {
        }
      );
  }


  search(event) {
    let searchString: string = event.target.value;
    this.onSearch(searchString);
  }

  onLocationSelected(selectedLocation: WeatherLocation) {
    this.selectedLocation = selectedLocation;
  }

  saveLocation(location: WeatherLocation) {
    const existsAlready = typeof this.locations.find(y => y.geonameid == location.geonameid) !== 'undefined';
    if (existsAlready) {
      console.log('Exists already');
      return;
    }

    this.weatherLocationService.saveLocation(location)
      .subscribe(
        savedLocation => this._onSaveLocation(savedLocation),
        () => {
        });
  }

  _onSaveLocation(location: WeatherLocation) {
    this.locations.push(location);
  }

  setCurrentLocation(location: WeatherLocation, isCurrent: boolean) {
    location.current = isCurrent;
    this.weatherLocationService.assertAtLeastOneCurrent(this.locations)
      .subscribe(
        () => {
        },
        (err) => console.log(err));

    this.weatherLocationService.setCurrentLocation(location)
      .subscribe(
        current => this._onSetCurrentLocation(current),
        () => {
        });
  }

  _onSetCurrentLocation(location: WeatherLocation) {
    this.locations.forEach(loc => {
      if (loc.id !== location.id) {
        loc.current = false;
      } else {
        loc.current = location.current;
      }
    });
  }

  locationViewValueFormatter = (x: { place: string }) => x.place;

}
