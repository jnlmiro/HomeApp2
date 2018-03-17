package com.jorgma.homeapp.sl.service;

import com.jorgma.homeapp.sl.business.SlDeparturesBl;
import com.jorgma.homeapp.sl.domain.DepartureGroup;
import com.jorgma.homeapp.sl.domain.SlDeparturesRestApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2017-12-02.
 */
@Service
public class SlDeparturesServiceImpl implements SlDeparturesService {

    @Autowired
    SlDeparturesBl slDeparturesBl;

    @Override
    public SlDeparturesRestApiResponse getDepartureGroups(int siteId) {

        return slDeparturesBl.getDepartureGroups(siteId);
    }
}

