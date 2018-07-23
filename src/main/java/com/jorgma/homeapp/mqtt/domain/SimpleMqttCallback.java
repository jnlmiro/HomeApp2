package com.jorgma.homeapp.mqtt.domain;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

/**
 * Created by jorgma on 2018-06-29.
 */
public class SimpleMqttCallback implements MqttCallback {
    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Connection lost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        byte[] payload =  mqttMessage.getPayload();
        String str = new String(payload, StandardCharsets.UTF_8);
        System.out.println(String.format("Msg arrived: %s, %s", str, LocalDateTime.now().toString()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("Message delivered");
    }
}
