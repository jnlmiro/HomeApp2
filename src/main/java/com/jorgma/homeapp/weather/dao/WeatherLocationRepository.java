package com.jorgma.homeapp.weather.dao;

import com.jorgma.homeapp.weather.domain.WeatherLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jorgma on 2018-02-21.
 */
public interface WeatherLocationRepository extends PagingAndSortingRepository<WeatherLocation, Long> {
}
