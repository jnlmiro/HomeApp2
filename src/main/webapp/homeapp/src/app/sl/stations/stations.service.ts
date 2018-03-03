import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Rx';
import {Station} from "./station/station.model";
import {Http, Response} from "@angular/http";

@Injectable()
export class StationsService {
  private url: string = "/api/stations";

  constructor(private http: Http) {
  }

  public getStations(): Observable<Station[]> {
    return this.http.get(`${this.url}`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }


  public getStation(id: string): Observable<Station> {
    return this.http.get(`${this.url}/${id}`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }



  public searchExternalStation(searchStr: string): Observable<Station[]> {
    return this.http.get(`${this.url}/search?stationName=${searchStr}`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }
}
