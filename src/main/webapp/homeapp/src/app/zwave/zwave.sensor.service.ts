import {Injectable} from "@angular/core";
import {ZwaveSensor} from "./zwave.sensor.model";

@Injectable()
export class ZwaveSensorService {

  sensors: ZwaveSensor[] = [];


  addSensor(sensor: ZwaveSensor): void {
    let found = this.sensors.find(s => s.id == sensor.id && s.name == sensor.name);
    if (!found) {
      this.sensors.push(sensor);
    } else {
      found.value = sensor.value;
    }
  }

  updateSensorValue(sensorToUpdate: ZwaveSensor, sensor: ZwaveSensor): ZwaveSensor {
    sensorToUpdate.value = sensor.value;
    return sensorToUpdate;
  }

  jsonToZwaveSensor(msg: string):ZwaveSensor {
    console.log('jsonToZwaveSensor',msg);
    return JSON.parse(msg);
  }
}
