package com.jorgma.homeapp.weather.business;

import com.jorgma.homeapp.weather.domain.Weather;

/**
 * Created by jorgma on 2018-02-20.
 */
public interface WeatherBl {

    Weather getForCoordinates(double latitude, double longitude);
}
