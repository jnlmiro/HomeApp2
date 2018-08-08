package com.jorgma.homeapp.zwave.business;

import com.jorgma.homeapp.zwave.domain.ZwaveHaComponent;
import com.jorgma.homeapp.zwave.domain.ZwaveSensor;
import com.jorgma.homeapp.zwave.utils.AlarmUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jorgma on 2018-08-02.
 */
@Service
public class ZwaveComponentBlImpl implements ZwaveComponentBl {
    @Autowired
    private RestTemplate restTemplate;
    private String url = "http://192.168.1.155:8123/api/states";


    public List<ZwaveSensor> getSensorsFromHa() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-ha-access", "welcome");
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<ZwaveHaComponent[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, ZwaveHaComponent[].class);
        List<ZwaveHaComponent> allComponents = Arrays.asList(responseEntity.getBody());
        return allComponents.stream()
                .filter(zwaveComponent -> zwaveComponent.isSensor())
                .map(zwaveHaComponent -> toZwaveSensor(zwaveHaComponent))
                .collect(Collectors.toList());
    }

    @Override
    public List<ZwaveHaComponent> getSensors() {
        return null;
    }

    @Override
    public ZwaveSensor toZwaveSensor(ZwaveHaComponent zwaveHaComponent) {
        ZwaveSensor zwaveSensor = new ZwaveSensor();
        zwaveSensor.setId(zwaveHaComponent.getId());
        zwaveSensor.setName(zwaveHaComponent.getAttributes().getFriendlyName());
        zwaveSensor.setState(zwaveHaComponent.getState());
        zwaveSensor.setUnitOfMeasurement(zwaveHaComponent.getAttributes().getUnitOfMeasurement());
        zwaveSensor.setNodeId(zwaveHaComponent.getAttributes().getNodeId());
        zwaveSensor.setSensorType(zwaveHaComponent.getAttributes().getResponsibility());
        zwaveSensor = AlarmUtils.setAlarms(zwaveSensor);
        return zwaveSensor;
    }
}


