package com.jorgma.homeapp.weather.business;

import com.jorgma.homeapp.weather.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;

/**
 * Created by jorgma on 2018-02-20.
 */
@Repository
public class WeatherBlImpl implements WeatherBl {
    private final String url = "https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/$longitude/lat/$latitude/data.json";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Weather getForCoordinates(double latitude, double longitude) {

        DecimalFormat df = new DecimalFormat("#.####");
        Double latitude_ = Double.valueOf(df.format(latitude));
        Double longitude_ = Double.valueOf(df.format(longitude));

        return restTemplate.getForObject(buildUrl(latitude_, longitude_), Weather.class);
    }


    private String buildUrl(double latitude, double longitude) {
        String builtUrl = url;
        return builtUrl.replace("$latitude", String.valueOf(latitude)).replace("$longitude", String.valueOf(longitude));
    }
}
