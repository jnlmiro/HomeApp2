import {Component} from "@angular/core";
import {Station} from "./station.model";
import {StationsService} from "./../stations.service";

@Component({
  selector: 'station',
  templateUrl: 'station.component.html',
  styleUrls: ['station.component.scss']
})
export class StationComponent {
  private station: Station;

  constructor(private stationService: StationsService) {
  }


  public getStation(id: string) {
    this.stationService.getStation(id)
      .subscribe(station => this.station = station);
  }
}
