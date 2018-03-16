package com.jorgma.homeapp.weather.rest;

import com.jorgma.homeapp.weather.domain.Weather;
import com.jorgma.homeapp.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jorgma on 2018-02-23.
 */
@RestController
@RequestMapping("/api/weather-forecast")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Weather getForecastForWeatherLocation(@RequestParam("latitude") double latitude, @RequestParam("longitude") double longitude) {
        System.out.println("hej");
        return weatherService.getForCoordinates(latitude, longitude);
    }
}
