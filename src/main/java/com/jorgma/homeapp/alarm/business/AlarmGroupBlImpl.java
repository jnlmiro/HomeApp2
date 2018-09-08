package com.jorgma.homeapp.alarm.business;

import com.jorgma.homeapp.alarm.dao.AlarmGroupRepository;
import com.jorgma.homeapp.alarm.domain.AlarmGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    @Override
    public AlarmGroup createAlarmGroup(AlarmGroup alarmGroup) {
        return alarmGroupRepository.save(alarmGroup);
    }

    @Override
    public AlarmGroup updateAlarmGroup(int id, AlarmGroup alarmGroup) {
        AlarmGroup existingAlarmGroup = alarmGroupRepository.findOne(id);
        assert existingAlarmGroup != null;
        return alarmGroupRepository.save(alarmGroup);
    }
}
