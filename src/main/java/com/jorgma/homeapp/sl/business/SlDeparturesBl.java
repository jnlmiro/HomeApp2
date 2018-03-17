package com.jorgma.homeapp.sl.business;

import com.jorgma.homeapp.sl.domain.SlDeparturesRestApiResponse;

/**
 * Created by jorgma on 2018-03-17.
 */
public interface SlDeparturesBl {
    SlDeparturesRestApiResponse getDepartureGroups(int siteId);
}
