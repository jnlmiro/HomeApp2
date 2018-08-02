import {Injectable} from "@angular/core";
import {ZwaveSensor} from "./zwave.sensor.model";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ZwaveSensorService {
  sensors: ZwaveSensor[] = [];
  url: string = '/api/zwave/sensors';


  constructor(private httpClient: HttpClient) {
  }


  getSensors(): Observable<ZwaveSensor[]> {
    return this.httpClient.get(this.url);
  }

  addSensor(sensor: ZwaveSensor): void {
    let found = this.sensors.find(s => s.id == sensor.id && s.name == sensor.name);
    if (!found) {
      this.sensors.push(sensor);
    } else {
      found.state = sensor.state;
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
    } catch (Error) {
      console.log(`Error when parsing ${msg}`);
    }
    return obj;
  }
}
