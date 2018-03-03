package com.jorgma.homeapp.weather.service;

import com.jorgma.homeapp.weather.business.WeatherLocationBl;
import com.jorgma.homeapp.weather.domain.WeatherLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Watchable;
import java.util.List;

/**
 * Created by jorgma on 2018-02-23.
 */
@Service
public class WeatherLocationServiceImpl implements WeatherLocationService {

    @Autowired
    WeatherLocationBl weatherLocationBl;


    @Override
    public void saveWeatherLocation(WeatherLocation weatherLocation) {
        weatherLocationBl.saveWeatherLocation(weatherLocation);
    }

    @Override
    public List<WeatherLocation> getAllWeatherLocations() {
        return weatherLocationBl.getAllWeatherLocations();
    }

    @Override
    public List<WeatherLocation> searchWeatherLocation(String place) {
        return weatherLocationBl.searchWeatherLocation(place);
    }
}
