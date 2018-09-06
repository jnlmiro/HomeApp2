/**
 * Created by jorgma on 2017-08-08.
 */
import {Component, OnInit} from '@angular/core';
import {StationsService} from "./stations/stations.service";
import {Station} from "./stations/station/station.model";

@Component({
  selector: 'sl',
  templateUrl: 'sl.component.html'
})
export class SlComponent implements OnInit {


  enabledStations:Station[] = [];

  constructor(private stationsService:StationsService) {
  }

  ngOnInit() {
    this.stationsService.getEnabledStations()
      .subscribe(stations => this.enabledStations = stations);
  }
}
