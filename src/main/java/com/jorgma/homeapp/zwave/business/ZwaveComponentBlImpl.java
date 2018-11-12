package com.jorgma.homeapp.zwave.business;

import com.jorgma.homeapp.zwave.dao.ZwaveSensorRepository;
import com.jorgma.homeapp.zwave.domain.ZwaveHaComponent;
import com.jorgma.homeapp.zwave.domain.ZwaveSensor;
import com.jorgma.homeapp.zwave.utils.AlarmUtils;
import com.jorgma.homeapp.zwave.utils.HaRestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
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
@Profile("!mock")
@Service()
public class ZwaveComponentBlImpl implements ZwaveComponentBl {
    @Autowired
    private RestTemplate restTemplate;
    private String url = "http://192.168.1.155:8123/api/states";

    @Autowired
    private ZwaveSensorRepository zwaveSensorRepository;

    public List<ZwaveSensor> getSensorsFromHa() {

        HttpEntity<String> entity = HaRestUtils.buildHttpEntity("welcome");
        ResponseEntity<ZwaveHaComponent[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, ZwaveHaComponent[].class);
        List<ZwaveHaComponent> allComponents = Arrays.asList(responseEntity.getBody());
        List<ZwaveSensor> zwaveSensors = allComponents.stream()
                .filter(zwaveComponent -> zwaveComponent.isSensor())
                .map(zwaveHaComponent -> toZwaveSensor(zwaveHaComponent))
                .map(zwaveSensor -> mergeAndUpdate(zwaveSensor))
                .collect(Collectors.toList());
        return zwaveSensors;
    }

    @Override
    public ZwaveSensor getSensorFromHa(String haId) {
        HttpEntity<String> entity = HaRestUtils.buildHttpEntity("welcome");
        String _url = String.format("%s/%s", url, haId);
        ResponseEntity<ZwaveHaComponent> responseEntity = restTemplate.exchange(_url, HttpMethod.GET, entity, ZwaveHaComponent.class);
        ZwaveHaComponent zwaveHaComponent = responseEntity.getBody();
        return toZwaveSensor(zwaveHaComponent);
    }

    @Override
    public List<ZwaveHaComponent> getHaComponents() {
        return null;
    }

    @Override
    public ZwaveSensor toZwaveSensor(ZwaveHaComponent zwaveHaComponent) {
        ZwaveSensor zwaveSensor = new ZwaveSensor();
        zwaveSensor.setHaId(zwaveHaComponent.getId());
        zwaveSensor.setName(zwaveHaComponent.getAttributes().getFriendlyName());
        zwaveSensor.setState(zwaveHaComponent.getState());
        zwaveSensor.setUnitOfMeasurement(zwaveHaComponent.getAttributes().getUnitOfMeasurement());
        zwaveSensor.setNodeId(zwaveHaComponent.getAttributes().getNodeId());
        zwaveSensor.setSensorType(zwaveHaComponent.getAttributes().getResponsibility());
        zwaveSensor = AlarmUtils.setAlarms(zwaveSensor);
        return zwaveSensor;
    }

    private ZwaveSensor mergeAndUpdate(ZwaveSensor zwaveSensorFromHa) {
        ZwaveSensor zwaveSensor = zwaveSensorRepository.findByHaId(zwaveSensorFromHa.getHaId());
        if (zwaveSensor != null) {
            zwaveSensorFromHa.setName(zwaveSensor.getName());
        }
        return zwaveSensorFromHa;
    }


    public void save(ZwaveSensor sensor) {
        zwaveSensorRepository.save(sensor);
    }

    @Override
    public ZwaveSensor saveSensor(ZwaveSensor zwaveSensor) {
        return zwaveSensorRepository.save(zwaveSensor);
    }

    @Override
    public List<ZwaveSensor> getAllSensors() {
        return (List<ZwaveSensor>) zwaveSensorRepository.findAll();
    }


    @Override
    public ZwaveSensor getSensor(int id) {
        return zwaveSensorRepository.findOne(id);
    }

}


