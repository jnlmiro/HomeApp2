package com.jorgma.homeapp.zwave.rest;

import com.jorgma.homeapp.zwave.service.ZwaveWsService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * Created by jorgma on 2018-07-08.
 */
@Controller
public class ZwaveWebSocketController {

    private ZwaveWsService zwaveWsService;

    public ZwaveWebSocketController(ZwaveWsService zwaveWsService) {
        this.zwaveWsService = zwaveWsService;
    }

    @MessageMapping("/send/message")
    public void onReceived(String message) {
        zwaveWsService.send(message);
    }
}
