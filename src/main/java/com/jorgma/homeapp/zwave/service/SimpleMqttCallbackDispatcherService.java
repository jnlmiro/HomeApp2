package com.jorgma.homeapp.zwave.service;

/**
 * Created by jorgma on 2018-07-30.
 */
public interface SimpleMqttCallbackDispatcherService {
    void dispatch(String topic, String msg);
}
