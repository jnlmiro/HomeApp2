package com.jorgma.homeapp.sl.business;

import com.jorgma.homeapp.sl.dao.StationsRepository;
import com.jorgma.homeapp.sl.domain.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
@Repository
public class StationBlImpl implements StationBl {
    @Autowired
    private StationsRepository stationsRepository;


    @Override
    public void saveStation(Station station) {
        stationsRepository.save(station);
    }

    @Override
    public Station getStation(int id) {
        return stationsRepository.findOne(id);
    }

    @Override
    public List<Station> getStations() {
        return (List<Station>) stationsRepository.findAll();
    }

    @Override
    public void deleteStation(int id) {
        stationsRepository.delete(id);
    }

    @Override
    public List<Station> getEnabledStations() {
        return stationsRepository.findByEnabled(true);
    }

}
