import {Injectable} from '@angular/core';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {WeatherLocation} from "../weather.model";

@Injectable()
export class WeatherLocationService {
  searchLocationUrl = `/api/weather-locations/search`;
  locationUrl = `/api/weather-locations`;

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

  getAllLocations(): Observable<WeatherLocation[]> {
    return this.httpClient.get(this.locationUrl)
      .catch(this.handleError);
  }


  saveLocation(location): Observable<WeatherLocation> {
    return this.httpClient.post<WeatherLocation>(this.locationUrl, location)
      .catch(this.handleError);
  }

  setCurrentLocation(location): Observable<WeatherLocation> {
    return this.httpClient.put(this.locationUrl, location)
      .catch(this.handleError);
  }

  assertAtLeastOneCurrent(locations): Observable<any> {
    const currentLocation: WeatherLocation = locations.find(loc => loc.current === true);
    if (!currentLocation) {
      return Observable.throw("At least one weather location must be set to current");
    }
    return Observable.from(locations);
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);

  }

  removeLocation(location:WeatherLocation): Observable<WeatherLocation> {
    let params = new HttpParams();
    params = params.append('id', location.id.toString());
    return this.httpClient.delete(this.locationUrl, {params:params});
  }
}
