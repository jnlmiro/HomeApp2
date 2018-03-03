package com.jorgma.homeapp.weather.business;

import com.jorgma.homeapp.weather.domain.WeatherLocation;

import java.util.List;

/**
 * Created by jorgma on 2018-02-23.
 */
public interface WeatherLocationBl {

    void saveWeatherLocation(WeatherLocation weatherLocation);

    List<WeatherLocation> getAllWeatherLocations();

    List<WeatherLocation> searchWeatherLocation(String place);
}
