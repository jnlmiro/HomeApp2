package com.jorgma.homeapp.zwave.business;

/**
 * Created by jorgma on 2018-07-30.
 */
public interface SimpleMqttCallbackDispatcherBl {

    void dispatch(String topic, String msg);
}
