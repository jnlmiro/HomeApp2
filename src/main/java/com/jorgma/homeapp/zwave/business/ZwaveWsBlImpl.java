package com.jorgma.homeapp.zwave.business;

import com.google.gson.Gson;
import com.jorgma.homeapp.zwave.domain.ZwaveSensor;
import com.jorgma.homeapp.zwave.utils.AlarmUtils;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jorgma on 2018-07-30.
 */
@Service
public class ZwaveWsBlImpl implements ZwaveWsBl {

    private SimpMessagingTemplate messagingTemplate;

    public ZwaveWsBlImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public void send(String msg) {
        Gson gson = new Gson();
        try {
            ZwaveSensor sensor = gson.fromJson(msg, ZwaveSensor.class);
            sensor = AlarmUtils.setAlarms(sensor);
            System.out.println(msg);
            msg = gson.toJson(sensor);
            messagingTemplate.convertAndSend("/topic", msg);
        }catch (Exception e) {
        }
    }
}
