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

    List<ZwaveHaComponent> getSensors();

    ZwaveComponent toZwaveSensor(ZwaveHaComponent zwaveHaComponent);
}
