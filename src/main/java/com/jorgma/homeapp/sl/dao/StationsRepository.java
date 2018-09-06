package com.jorgma.homeapp.sl.dao;

import com.jorgma.homeapp.sl.domain.Station;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by jorgma on 2018-02-21.
 */
public interface StationsRepository extends PagingAndSortingRepository<Station, Integer> {
    Station findBySiteId(int siteId);

    List<Station> findByEnabled(boolean enabled);
}
