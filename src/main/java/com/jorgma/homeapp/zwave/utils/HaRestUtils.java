package com.jorgma.homeapp.zwave.utils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

/**
 * Created by jorgma on 2018-08-27.
 */
public class HaRestUtils {


    public static HttpEntity buildHttpEntity(String pwd) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-ha-access", pwd);
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return entity;
    }
}
