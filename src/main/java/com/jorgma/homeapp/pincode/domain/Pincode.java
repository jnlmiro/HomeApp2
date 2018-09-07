package com.jorgma.homeapp.pincode.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jorgma.homeapp.alarm.domain.AlarmGroup;

import javax.persistence.*;

/**
 * Created by jorgma on 2018-08-22.
 */
@Entity(name = "pincodes")
public class Pincode {
    @Id
    @GeneratedValue
    private int id;
    private String code;

    @OneToOne
    @JoinColumn(referencedColumnName = "alarm_group")
    private AlarmGroup alarmGroup;

    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public AlarmGroup getAlarmGroup() {
        return alarmGroup;
    }

    public void setAlarmGroup(AlarmGroup alarmGroup) {
        this.alarmGroup = alarmGroup;
    }
}
