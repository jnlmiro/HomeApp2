package com.jorgma.homeapp.mqtt.service;

import com.jorgma.homeapp.configuration.MqttConfigurationContainer;
import com.jorgma.homeapp.mqtt.domain.SimpleMqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2018-06-29.
 */
@Service
public class HomeAssistantClient {

    private MqttConfigurationContainer mqttConfigurationContainer;

    private MqttClient mqttClient;

    public HomeAssistantClient(MqttConfigurationContainer mqttConfigurationContainer) {
        this.mqttConfigurationContainer = mqttConfigurationContainer;
        createMqttClient();
    }


    private void createMqttClient() {
        if (mqttClient == null) {
            try {
                mqttClient = new MqttClient(mqttConfigurationContainer.getTcpBrokerUrl(), MqttClient.generateClientId());
                mqttClient.setCallback(new SimpleMqttCallback());
                mqttClient.connect();
                mqttClient.subscribe("homeassistant/#");
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

}
