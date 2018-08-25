package com.jorgma.homeapp.pincode.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jorgma on 2018-08-22.
 */
@Entity(name = "pincodes")
public class Pincode {
    @Id
    @GeneratedValue
    private int id;
    private int code;

    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
