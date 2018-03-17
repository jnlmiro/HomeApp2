package com.jorgma.homeapp.weather.rest;

import com.jorgma.homeapp.weather.domain.WeatherLocation;
import com.jorgma.homeapp.weather.service.WeatherLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by jorgma on 2018-02-23.
 */

@RestController
@RequestMapping("/api/weather-locations")
public class WeatherLocationController {
    @Autowired
    WeatherLocationService weatherLocationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public WeatherLocation saveWeatherLocation(@RequestBody WeatherLocation weatherLocation, HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(HttpStatus.CREATED.value());
        return weatherLocationService.saveWeatherLocation(weatherLocation);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public WeatherLocation setCurrentWeatherLocation(@RequestBody WeatherLocation weatherLocation) {
        return weatherLocationService.setCurrentWeatherLocation(weatherLocation);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public WeatherLocation removeWeatherLocation(@RequestParam("id") int id) {
        return weatherLocationService.removeWeatherLocation(id);
    }

    @RequestMapping(value = "current", method = RequestMethod.GET)
    public WeatherLocation getCurrentWeatherLocation() {
        return weatherLocationService.getCurrentWeatherLocation().get();
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
