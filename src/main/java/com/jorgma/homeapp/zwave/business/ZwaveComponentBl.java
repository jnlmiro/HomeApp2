package com.jorgma.homeapp.zwave.business;

import com.jorgma.homeapp.zwave.domain.ZwaveHaComponent;
import com.jorgma.homeapp.zwave.domain.ZwaveComponent;
import com.jorgma.homeapp.zwave.domain.ZwaveSensor;

import java.util.List;

/**
 * Created by jorgma on 2018-08-02.
 */
public interface ZwaveComponentBl {

    List<ZwaveSensor> getSensorsFromHa();

    List<ZwaveHaComponent> getHaComponents();

    ZwaveComponent toZwaveSensor(ZwaveHaComponent zwaveHaComponent);

    ZwaveSensor getSensorFromHa(String haId);

    ZwaveSensor saveSensor(ZwaveSensor zwaveSensor);

    List<ZwaveSensor> getAllSensors();

    ZwaveSensor getSensor(int id);
}
