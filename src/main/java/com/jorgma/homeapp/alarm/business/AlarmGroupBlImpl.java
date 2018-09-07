package com.jorgma.homeapp.alarm.business;

import com.jorgma.homeapp.alarm.dao.AlarmGroupRepository;
import com.jorgma.homeapp.alarm.domain.AlarmGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jorgma on 2018-09-07.
 */
@Service
public class AlarmGroupBlImpl implements AlarmGroupBl {

    @Autowired
    private AlarmGroupRepository alarmGroupRepository;

    @Override
    public List<AlarmGroup> getAlarmGroups() {
        return (List<AlarmGroup>) alarmGroupRepository.findAll();
    }
}
