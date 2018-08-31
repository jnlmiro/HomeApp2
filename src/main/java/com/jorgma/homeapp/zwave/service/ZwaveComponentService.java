package com.jorgma.homeapp.zwave.service;

import com.jorgma.homeapp.zwave.domain.ZwaveHaComponent;
import com.jorgma.homeapp.zwave.domain.ZwaveSensor;

import java.util.List;

/**
 * Created by jorgma on 2018-08-02.
 */
public interface ZwaveComponentService {
    List<ZwaveSensor> getSensorsFromHa();

    ZwaveSensor getSensorFromHa(String haId);

    List<ZwaveHaComponent> getHaComponents();
}
