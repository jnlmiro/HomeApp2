package com.jorgma.homeapp.zwave.domain;

/**
 * Created by jorgma on 2018-08-08.
 */
public class ZwaveSensor extends ZwaveComponent {

    private String sensorType;
    private String unitOfMeasurement;
    private boolean alarming;


    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }


    public boolean isAlarming() {
        return alarming;
    }

    public void setAlarming(boolean alarming) {
        this.alarming = alarming;
    }
}
