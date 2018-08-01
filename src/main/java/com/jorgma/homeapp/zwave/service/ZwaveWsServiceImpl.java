package com.jorgma.homeapp.zwave.service;

import com.jorgma.homeapp.zwave.business.ZwaveWsBl;
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
