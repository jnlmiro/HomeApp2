package com.jorgma.homeapp.zwave.service;

import com.jorgma.homeapp.zwave.business.SimpleMqttCallbackDispatcherBl;
import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2018-07-30.
 */
@Service
public class SimpleMqttCallbackDispatcherServiceImpl implements SimpleMqttCallbackDispatcherService {
    private SimpleMqttCallbackDispatcherBl simpleMqttCallbackDispatcherBl;

    public SimpleMqttCallbackDispatcherServiceImpl(SimpleMqttCallbackDispatcherBl simpleMqttCallbackDispatcherBl) {
        this.simpleMqttCallbackDispatcherBl = simpleMqttCallbackDispatcherBl;
    }

    @Override
    public void dispatch(String topic, String msg) {
    simpleMqttCallbackDispatcherBl.dispatch(topic, msg);
    }
}
