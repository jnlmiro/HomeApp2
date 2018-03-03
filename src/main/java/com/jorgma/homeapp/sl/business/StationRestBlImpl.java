package com.jorgma.homeapp.sl.business;

import com.jorgma.homeapp.sl.domain.StationTrafikLab;
import com.jorgma.homeapp.sl.domain.StationsRestApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jorgma on 2017-12-10.
 */
@Service
public class StationRestBlImpl implements StationRestBl {

    private RestTemplate stationsSearchRestTemplate;
    private String uriTemplate = "http://api.sl.se/api2/typeahead.json?key={key}&searchstring={searchstring}";


    public StationRestBlImpl(RestTemplate stationsSearchRestTemplate) {
        this.stationsSearchRestTemplate = stationsSearchRestTemplate;
    }

    @Override
    public List<StationTrafikLab> searchStations(String searchParam) {
        URI uri = buildUri(searchParam);
        return stationsSearchRestTemplate.getForObject(uri, StationsRestApiResponse.class).getResponseData();
    }


    private URI buildUri(String searchParam) {
        Map<String, String> params = new HashMap<>();
        params.put("key", "999f837b37894d4d8741b88e2d073660");
        params.put("searchstring", searchParam);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.uriTemplate);
        return builder.buildAndExpand(params).toUri();

    }
}
