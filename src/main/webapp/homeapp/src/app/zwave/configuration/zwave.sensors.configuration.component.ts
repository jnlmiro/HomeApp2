import {Component, OnInit} from '@angular/core';
import {ZwaveSensorService} from "../zwave.sensor.service";
import {ZwaveSensor} from "../zwave.sensor.model";

@Component({
  selector: 'zwave-sensors-configuration',
  templateUrl: './zwave.sensors.configuration.component.html'
})
export class ZwaveSensorsConfigurationComponent implements OnInit {
  title: string = "Zwave Sensors Configuration";
  sensors: ZwaveSensor[] = [];
  selectedSensors: ZwaveSensor[] = [];

  constructor(private zwaveSensorService: ZwaveSensorService) {

  }

  ngOnInit() {
    this.getSensors();
  }


  getSensors() {
    this.zwaveSensorService.getSensors()
      .subscribe(sensors => {
        sensors.forEach(sensor => this.zwaveSensorService.addSensor(sensor));
        this.sensors = this.zwaveSensorService.sensors;
      });
  }


  selectSensor(sensor: ZwaveSensor): void {
    var foundSensor = this.selectedSensors.find(s => s.haId === sensor.haId);
    if (!foundSensor) {
      this.selectedSensors.push(sensor);
    }
  }


  deselectSensor(sensor: ZwaveSensor): void {
    var foundSensor = this.selectedSensors.find(s => s.haId === sensor.haId);
    if (foundSensor) {
      this.selectedSensors = this.selectedSensors.filter(s => s.haId !== sensor.haId)
    }
  }


  isSelected(sensor: ZwaveSensor): boolean {
    return !!this.selectedSensors.find(s => s.haId === sensor.haId);
  }
}
