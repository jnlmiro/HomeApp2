package com.jorgma.homeapp.zwave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jorgma on 2018-07-08.
 */
@Controller
public class BurglarWebSocketController {
    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/send")
    public void onReceived(String message) {
        this.template.convertAndSend("/topic", new SimpleDateFormat("HH:mm:ss").format(new Date()) + " - " + message);
    }
}
