package com.jorgma.homeapp.alarm.service;

import com.jorgma.homeapp.alarm.domain.AlarmGroup;

import java.util.List;

/**
 * Created by jorgma on 2018-09-07.
 */
public interface AlarmGroupService {
    List<AlarmGroup> getAlarmGroups();

    AlarmGroup createAlarmGroup(AlarmGroup alarmGroup);

    AlarmGroup updateAlarmGroup(int id, AlarmGroup alarmGroup);
}
