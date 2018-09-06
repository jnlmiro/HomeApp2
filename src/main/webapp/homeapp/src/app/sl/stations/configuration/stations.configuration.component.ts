import {Component, OnInit} from "@angular/core";
import {StationsService} from "../stations.service";
import {Station} from "../station/station.model";


@Component({
  selector: 'stations',
  templateUrl: './stations.configuration.component.html',
  styleUrls: ['./stations.configuration.component.scss']
})
export class StationsConfigurationComponent implements OnInit {

  stations: Station[];
  stationsSearchResult: Station[] = [];
  searchString: string;

  constructor(private stationsService: StationsService) {

  }


  ngOnInit(): void {
    this.getStations()
  }

  getStations() {
    this.stationsService.getStations()
      .subscribe(stations => this.stations = stations);
  }

  search(stationName: string): void {
    this.stationsService.searchStation(stationName)
      .subscribe(stations => this.stationsSearchResult = stations);
  }


  saveStation(station: Station): void {
    this.stationsService.saveStation(station)
      .subscribe(_ => this.getStations());
  }


  enableStation(station: Station, enabled: boolean) {
    station.enabled = enabled;
    this.saveStation(station);
  }


  removeStation(station:Station):void {
    this.stationsService.removeStation(station)
      .subscribe(_ => this.getStations());
  }
}
