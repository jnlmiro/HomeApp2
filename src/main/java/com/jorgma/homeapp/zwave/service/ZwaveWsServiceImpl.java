package com.jorgma.homeapp.zwave.service;

import com.google.gson.Gson;
import com.jorgma.homeapp.zwave.business.ZwaveWsBl;
import com.jorgma.homeapp.zwave.domain.ZwaveSensor;
import com.jorgma.homeapp.zwave.utils.AlarmUtils;
import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2018-07-30.
 */
@Service
public class ZwaveWsServiceImpl implements ZwaveWsService {

    private ZwaveWsBl zwaveWsBl;

    public ZwaveWsServiceImpl(ZwaveWsBl zwaveWsBl) {
        this.zwaveWsBl = zwaveWsBl;
    }

    @Override
    public void send(String msg) {
        zwaveWsBl.send(msg);
    }
}
