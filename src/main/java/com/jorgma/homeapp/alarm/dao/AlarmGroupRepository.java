package com.jorgma.homeapp.alarm.dao;

import com.jorgma.homeapp.alarm.domain.AlarmGroup;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jorgma on 2018-09-07.
 */
public interface AlarmGroupRepository extends PagingAndSortingRepository<AlarmGroup, Integer> {
}
