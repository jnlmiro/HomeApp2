package com.jorgma.homeapp.alarm.rest;

import com.jorgma.homeapp.alarm.domain.AlarmGroup;
import com.jorgma.homeapp.alarm.service.AlarmGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public AlarmGroup createAlarmGroup(@RequestBody AlarmGroup alarmGroup) {
        return alarmGroupService.createAlarmGroup(alarmGroup);
    }


    @RequestMapping(value = "/{id}",  method = RequestMethod.PUT)
    public AlarmGroup updateAlarmGroup(@PathVariable int id, @RequestBody AlarmGroup alarmGroup) {
        return alarmGroupService.updateAlarmGroup(id, alarmGroup);
    }
}
