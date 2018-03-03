package com.jorgma.homeapp.sl.business;

import com.jorgma.homeapp.sl.dao.StationDao;
import com.jorgma.homeapp.sl.domain.Station;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
@Repository
public class StationBlImpl implements StationBl {
    private StationDao stationDao;

    public StationBlImpl(StationDao stationDao) {
        this.stationDao = stationDao;
    }

    @Override
    public void saveStation(Station station) {
        stationDao.saveStation(station);
    }

    @Override
    public Station getStation(int id) {
        return stationDao.getStation(id);
    }

    @Override
    public List<Station> getStations() {
        return stationDao.getStations();
    }

    @Override
    public void deleteStation(int id) {
        stationDao.deleteStation(id);
    }
}
