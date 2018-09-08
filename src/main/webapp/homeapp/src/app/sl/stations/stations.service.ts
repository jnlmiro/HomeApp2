import {Injectable} from "@angular/core";
import {Observable} from 'rxjs/Rx';
import {Station} from "./station/station.model";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class StationsService {
  private url: string = "/api/stations";

  constructor(private httpClient: HttpClient) {
  }

  public getStations(): Observable<Station[]> {
    return this.httpClient.get<Station[]>(`${this.url}`)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }


  public getStation(id: string): Observable<Station> {
    return this.httpClient.get<Station>(`${this.url}/${id}`)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }


  public searchStation(searchStr: string): Observable<Station[]> {
    return this.httpClient.get<Station[]>(`${this.url}/search?stationName=${searchStr}`)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }

  public saveStation(station: Station): Observable<any> {
    return this.httpClient.post<Station>(`${this.url}`, station)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }


  updateStation(station: Station): Observable<Station> {
    return this.httpClient.put<Station>(`${this.url}`, station)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }

  public removeStation(station: Station): Observable<any> {
    return this.httpClient.delete(`${this.url}/${station.id}`)
      .map(res => res)
      .catch((error: any) => Observable.throw(error) || 'Service error');
  }

  getEnabledStations(): Observable<Station[]> {
    return this.httpClient.get<Station[]>(`${this.url}/enabled`)
      .map(res => res)
      .catch((error: any) => Observable.throw(error || 'Server error'));
  }


}
