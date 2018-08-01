package com.jorgma.homeapp.zwave.business;

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
        messagingTemplate.convertAndSend("/topic", msg);
    }
}
