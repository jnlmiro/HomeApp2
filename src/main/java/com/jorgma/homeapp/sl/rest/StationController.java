package com.jorgma.homeapp.sl.rest;

import com.jorgma.homeapp.sl.domain.Station;
import com.jorgma.homeapp.sl.domain.StationTrafikLab;
import com.jorgma.homeapp.sl.service.StationService;
import com.jorgma.homeapp.sl.service.TrafikLabStationsRestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jorgma on 2017-12-10.
 */
@RestController
@RequestMapping("/api/stations")
public class StationController {

    private StationService stationService;
    private TrafikLabStationsRestService trafikLabStationsRestService;

    public StationController(StationService stationService, TrafikLabStationsRestService trafikLabStationsRestService) {
        this.stationService = stationService;
        this.trafikLabStationsRestService = trafikLabStationsRestService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public void saveStation(@RequestBody Station station) {
        stationService.saveStation(station);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Station getStation(@PathVariable int id) {
        return stationService.getStation(id);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Station> getStations() {
        return stationService.getStations();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStation(int id) {
        stationService.deleteStation(id);
    }


    @RequestMapping(value = "search", method = RequestMethod.GET)
    public List<StationTrafikLab> searchStations(@RequestParam String stationName) {
        return trafikLabStationsRestService.searchStations(stationName);
    }

}
