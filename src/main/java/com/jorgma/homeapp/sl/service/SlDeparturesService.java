package com.jorgma.homeapp.sl.service;

import com.jorgma.homeapp.sl.domain.SlDeparturesRestApiResponse;

/**
 * Created by jorgma on 2017-12-02.
 */
public interface SlDeparturesService {
    SlDeparturesRestApiResponse getDepartureGroups(int siteId);
}
