package com.jorgma.homeapp.sl.service;

import com.jorgma.homeapp.sl.business.StationBl;
import com.jorgma.homeapp.sl.domain.Station;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
@Service
public class StationServiceImpl implements StationService {
    private StationBl stationBl;

    public StationServiceImpl(StationBl stationBl) {
        this.stationBl = stationBl;
    }

    @Override
    public void saveStation(Station station) {
        stationBl.saveStation(station);
    }

    @Override
    public Station getStation(int id) {
        return stationBl.getStation(id);
    }

    @Override
    public List<Station> getStations() {
        return stationBl.getStations();
    }

    @Override
    public void deleteStation(int id) {
        stationBl.deleteStation(id);
    }
}
