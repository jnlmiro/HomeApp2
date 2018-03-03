package com.jorgma.homeapp.sl.service;

import com.jorgma.homeapp.sl.business.StationRestBl;
import com.jorgma.homeapp.sl.domain.StationTrafikLab;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
@Service
public class TrafikLabStationsRestServiceImpl implements TrafikLabStationsRestService {

    private StationRestBl stationRestBl;

    public TrafikLabStationsRestServiceImpl(StationRestBl stationRestBl) {
        this.stationRestBl = stationRestBl;
    }

    @Override
    public List<StationTrafikLab> searchStations(String searchParam) {
        return stationRestBl.searchStations(searchParam);
    }
}
