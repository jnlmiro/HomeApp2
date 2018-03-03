package com.jorgma.homeapp.sl.service;

import com.jorgma.homeapp.sl.domain.StationTrafikLab;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
public interface TrafikLabStationsRestService {

    List<StationTrafikLab> searchStations(String searchParam);
}
