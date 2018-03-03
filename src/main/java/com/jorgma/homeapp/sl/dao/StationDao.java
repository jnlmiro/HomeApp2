package com.jorgma.homeapp.sl.dao;

import com.jorgma.homeapp.sl.domain.Station;

import java.util.List;

/**
 * Created by jorgma on 2017-12-12.
 */
public interface StationDao {


    void saveStation(Station station);

    Station getStation(int id);

    List<Station> getStations();

    void deleteStation(int siteId);
}
