package com.jorgma.homeapp.zwave.rest;

import com.jorgma.homeapp.zwave.domain.ZwaveHaComponent;
import com.jorgma.homeapp.zwave.domain.ZwaveSensor;
import com.jorgma.homeapp.zwave.service.ZwaveComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jorgma on 2018-07-08.
 */
@RestController
@RequestMapping("/api/zwave")
public class ZwaveComponentController {

    @Autowired
    private ZwaveComponentService zwaveComponentService;

    @RequestMapping(value = "/sensors", method = RequestMethod.GET)
    public List<ZwaveSensor> getSensorsFromHa() {
        return zwaveComponentService.getSensorsFromHa();
    }
}
