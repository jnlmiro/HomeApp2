package com.jorgma.homeapp.weather.business;

import com.jorgma.homeapp.weather.dao.WeatherLocationRepository;
import com.jorgma.homeapp.weather.domain.WeatherLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by jorgma on 2018-02-23.
 */
@Service
public class WeatherLocationBlImpl implements WeatherLocationBl {

    @Autowired
    WeatherLocationRepository weatherLocationRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public void saveWeatherLocation(WeatherLocation weatherLocation) {
        weatherLocationRepository.save(weatherLocation);
    }

    @Override
    public List<WeatherLocation> getAllWeatherLocations() {
        return (List<WeatherLocation>) weatherLocationRepository.findAll();
    }

    @Override
    public List<WeatherLocation> searchWeatherLocation(String place) {
        String url = "https://www.smhi.se/wpt-a/backend_solr/autocomplete/search/$place";
        ResponseEntity<List<WeatherLocation>> responseEntity = restTemplate.exchange(url.replace("$place", place), HttpMethod.GET, null, new ParameterizedTypeReference<List<WeatherLocation>>() {
        });
        List<WeatherLocation> weatherLocations = responseEntity.getBody();
        return weatherLocations;
    }
}
