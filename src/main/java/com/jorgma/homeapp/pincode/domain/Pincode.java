package com.jorgma.homeapp.pincode.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

//    @JsonIgnore(value = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @JsonIgnore(value = true)
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
