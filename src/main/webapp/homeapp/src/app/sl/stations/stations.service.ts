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


  public searchStation(searchStr: string): Observable<Station[]> {
    return this.http.get(`${this.url}/search?stationName=${searchStr}`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }

  public saveStation(station: Station): Observable<any> {
    return this.http.post(`${this.url}`, station)
      .map((res: Response) => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }

  public removeStation(station: Station):Observable<any> {
    return this.http.delete(`${this.url}/${station.id}`)
      .map((res:Response) => res)
      .catch((error:any) => Observable.throw(error) || 'Service error');
  }

  getEnabledStations():Observable<Station[]> {
    return this.http.get(`${this.url}/enabled`)
      .map((res: Response) => res.json())
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }
}
