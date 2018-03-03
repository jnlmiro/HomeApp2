

import {Component, OnInit} from "@angular/core";
import {StationsService} from "./stations.service";
import {Station} from "./station/station.model";



@Component({
  selector: 'stations',
  templateUrl: 'stations.component.html',
  styleUrls:['stations.component.scss']
})
export class StationsComponent implements OnInit{

  private stations:Station[];

  constructor(private stationsService:StationsService) {

  }


  ngOnInit(): void {
    this.stationsService.getStations()
      .subscribe(stations => this.stations = stations);
  }
}
