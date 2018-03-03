package com.jorgma.homeapp.weather.service;

import com.jorgma.homeapp.weather.business.WeatherBl;
import com.jorgma.homeapp.weather.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jorgma on 2018-02-20.
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    private WeatherBl weatherBl;

    @Override
    public Weather getForCoordinates(double latitude, double longitude) {
        return weatherBl.getForCoordinates(latitude, longitude);
    }
}
