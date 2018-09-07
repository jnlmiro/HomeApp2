package com.jorgma.homeapp.alarm.service;

import com.jorgma.homeapp.alarm.domain.AlarmGroup;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2018-09-07.
 */
public interface AlarmGroupService {
    List<AlarmGroup> getAlarmGroups();
}
