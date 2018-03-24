import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {RpiBackLight} from "./rpi-backlight.model";

@Injectable()
export class RpiBackLightService {
  url = '/api/rpi-backlight';

  constructor(private httpClient: HttpClient) {

  }

  getBackLightIntensity(): Observable<number> {
    return this.httpClient.get(this.url);
  }

  setBackLightIntensity(rpiBackLight:RpiBackLight): Observable<RpiBackLight> {
    return this.httpClient.post(this.url, rpiBackLight);
  }
}
