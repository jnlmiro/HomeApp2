package com.jorgma.homeapp.sl.business;

import com.jorgma.homeapp.sl.domain.StationTrafikLab;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
public interface StationRestBl {
    List<StationTrafikLab> searchStations(String searchParam);
}
