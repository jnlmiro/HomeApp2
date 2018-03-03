package com.jorgma.homeapp.weather.rest;

import com.jorgma.homeapp.weather.domain.WeatherLocation;
import com.jorgma.homeapp.weather.service.WeatherLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jorgma on 2018-02-23.
 */

@RestController
@RequestMapping("/api/weather-location")
public class WeatherLocationController {
    @Autowired
    WeatherLocationService weatherLocationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void saveWeatherLocation(@RequestBody WeatherLocation weatherLocation) {
        weatherLocationService.saveWeatherLocation(weatherLocation);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<WeatherLocation> getAllWeatherLocations() {
        return weatherLocationService.getAllWeatherLocations();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<WeatherLocation> searchWeatherLocation(@RequestParam("place") String place) {
        return weatherLocationService.searchWeatherLocation(place);
    }

}
