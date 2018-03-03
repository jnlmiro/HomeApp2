package com.jorgma.homeapp;

import com.jorgma.homeapp.weather.domain.Weather;
import com.jorgma.homeapp.weather.service.WeatherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by jorgma on 2018-02-20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmhiTests {
    @Autowired
    WeatherService weatherService;

    @Test
    public void testSmhiWeatherApi() {
        double latitude = 59.3293;
        double longitude = 18.0686;

        Weather weather = weatherService.getForCoordinates(latitude, longitude);
        Assert.assertNotNull(weather);
        Assert.assertNotNull(weather.getTimeSeries());
    }
}
