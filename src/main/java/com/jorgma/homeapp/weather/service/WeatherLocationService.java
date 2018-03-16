package com.jorgma.homeapp.weather.service;

import com.jorgma.homeapp.weather.domain.WeatherLocation;

import java.util.List;
import java.util.Optional;

/**
 * Created by jorgma on 2018-02-23.
 */
public interface WeatherLocationService {

    WeatherLocation saveWeatherLocation(WeatherLocation weatherLocation);

    WeatherLocation setCurrentWeatherLocation(WeatherLocation weatherLocation);

    List<WeatherLocation> getAllWeatherLocations();

    List<WeatherLocation> searchWeatherLocation(String place);

    Optional<WeatherLocation> getCurrentWeatherLocation();
}
