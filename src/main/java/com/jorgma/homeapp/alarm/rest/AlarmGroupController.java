package com.jorgma.homeapp.alarm.rest;

import com.jorgma.homeapp.alarm.domain.AlarmGroup;
import com.jorgma.homeapp.alarm.service.AlarmGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jorgma on 2018-09-07.
 */


@RestController
@RequestMapping("/api/alarm-groups")
public class AlarmGroupController {
    @Autowired
    private AlarmGroupService alarmGroupService;

    @RequestMapping(value = "",  method = RequestMethod.GET)
    public List<AlarmGroup> getAlarmGroups() {

        return alarmGroupService.getAlarmGroups();
    }


    @RequestMapping(value = "",  method = RequestMethod.POST)
    public AlarmGroup createAlarmGroups(AlarmGroup alarmGroup) {
        return alarmGroupService.createAlarmGroup(alarmGroup);
    }
}
