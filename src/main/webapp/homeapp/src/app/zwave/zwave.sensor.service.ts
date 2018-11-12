import {Injectable} from "@angular/core";
import {ZwaveSensor} from "./zwave.sensor.model";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ZwaveSensorService {
  sensors: ZwaveSensor[] = [];
  url: string = '/api/zwave/sensors';
  haUrl: string = '/api/zwave/ha-sensors';


  constructor(private httpClient: HttpClient) {
  }


  getHaSensors(): Observable<ZwaveSensor[]> {
    return this.httpClient.get(this.haUrl);
  }


  getHaSensor(haId: string): Observable<ZwaveSensor> {
    return this.httpClient.get(`this.haUrl/${haId}`);
  }

  addSensor(sensor: ZwaveSensor): void {
    let found = this.sensors.find(s => s.haId == sensor.haId);
    if (!found) {
      this.sensors.push(sensor);
    } else {
      found.state = sensor.state;
      found.alarming = sensor.alarming;
    }
  }

  updateSensorValue(sensorToUpdate: ZwaveSensor, sensor: ZwaveSensor): ZwaveSensor {
    sensorToUpdate = sensor;
    return sensorToUpdate;
  }

  jsonToZwaveSensor(msg: string): ZwaveSensor {
    let obj = new ZwaveSensor();
    try {
      obj = JSON.parse(msg);
      console.log(`Sensor automation received: ${obj}`);
    } catch (Error) {
      console.log(`Error when parsing ${msg}`);
    }
    return obj;
  }

  saveSensor(sensor: ZwaveSensor): Observable<ZwaveSensor> {
    return this.httpClient.post(this.url, sensor);
  }


  getSensors(): Observable<ZwaveSensor[]> {
    return this.httpClient.get(this.url);
  }


  getSensor(id:number): Observable<ZwaveSensor> {
    return this.httpClient.get(`this.url/${id}`);
  }

}
