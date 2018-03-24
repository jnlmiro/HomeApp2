package com.jorgma.homeapp.rpi.service;

import com.jorgma.homeapp.rpi.dao.RpiBackLight;

import java.io.IOException;

/**
 * Created by jorgma on 2018-03-24.
 */
public interface RpiBackLightService {
    int getBackLightIntensity();

    void setBackLightIntensity(RpiBackLight rpiBackLight) throws IOException;
}
