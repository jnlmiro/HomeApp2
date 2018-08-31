package com.jorgma.homeapp.zwave.service;

import com.jorgma.homeapp.zwave.business.ZwaveComponentBl;
import com.jorgma.homeapp.zwave.domain.ZwaveHaComponent;
import com.jorgma.homeapp.zwave.domain.ZwaveSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2018-08-02.
 */
@Service
public class ZwaveComponentServiceImpl implements ZwaveComponentService {

    @Autowired
    ZwaveComponentBl zwaveComponentBl;

    @Override
    public List<ZwaveSensor> getSensorsFromHa() {
        return zwaveComponentBl.getSensorsFromHa();
    }

    @Override
    public ZwaveSensor getSensorFromHa(String haId) {
        return zwaveComponentBl.getSensorFromHa(haId);
    }

    @Override
    public List<ZwaveHaComponent> getHaComponents() {
        return null;
    }
}
