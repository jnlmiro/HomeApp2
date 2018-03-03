import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {WeatherLocation} from "../weather.model";

@Injectable()
export class WeatherConfigService {
  searchLocationUrl = `/api/weather-location/search`;

  constructor(private httpClient: HttpClient) {
  }

  searchLocations(text): Observable<WeatherLocation[]> {
    let params = new HttpParams();
    params = params.append('place', text);
    return this.httpClient
      .get<WeatherLocation[]>(this.searchLocationUrl, {params: params})
      .map((response: WeatherLocation[]) => {
        return <WeatherLocation[]> response;
      })
      .catch(this.handleError);
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);

  }

}
