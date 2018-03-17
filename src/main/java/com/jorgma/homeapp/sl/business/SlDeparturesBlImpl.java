package com.jorgma.homeapp.sl.business;

import com.jorgma.homeapp.sl.domain.SlDeparturesRestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jorgma on 2018-03-17.
 */
@Service
public class SlDeparturesBlImpl implements SlDeparturesBl {
    @Autowired
    RestTemplate restTemplate;

    private final String SL_DEPARTURES_URL = "http://sl.se/api/sv/RealTime/GetDepartures/$siteId";

    public SlDeparturesRestApiResponse getDepartureGroups(int siteId) {
        return restTemplate.getForObject(getDepartureUrl(siteId), SlDeparturesRestApiResponse.class);
    }

    private String getDepartureUrl(int siteId) {
        return SL_DEPARTURES_URL.replace("$siteId", String.valueOf(siteId));
    }
}
