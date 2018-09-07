package com.jorgma.homeapp.alarm.business;

import com.jorgma.homeapp.alarm.domain.AlarmGroup;

import java.util.List;

/**
 * Created by jorgma on 2018-09-07.
 */
public interface AlarmGroupBl {
    List<AlarmGroup> getAlarmGroups();
}
