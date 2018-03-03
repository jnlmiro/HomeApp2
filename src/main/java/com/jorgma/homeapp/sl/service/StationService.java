package com.jorgma.homeapp.sl.service;

import com.jorgma.homeapp.sl.domain.Station;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
public interface StationService {

    void saveStation(Station station);

    Station getStation(int id);

    List<Station> getStations();

    void deleteStation(int id);
}
