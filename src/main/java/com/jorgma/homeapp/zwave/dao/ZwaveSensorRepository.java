package com.jorgma.homeapp.zwave.dao;

import com.jorgma.homeapp.zwave.domain.ZwaveSensor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jorgma on 2018-08-26.
 */
public interface ZwaveSensorRepository extends PagingAndSortingRepository<ZwaveSensor, Integer> {
    ZwaveSensor findByHaId(String haId);
}
