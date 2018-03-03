package com.jorgma.homeapp.weather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jorgma.homeapp.serializers.LocalDateTimeDeserializer;
import com.jorgma.homeapp.serializers.LocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jorgma on 2018-02-20.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime approvedTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime referenceTime;

    private List<TimeSeries> timeSeries;


    public LocalDateTime getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(LocalDateTime approvedTime) {
        this.approvedTime = approvedTime;
    }

    public LocalDateTime getReferenceTime() {
        return referenceTime;
    }

    public void setReferenceTime(LocalDateTime referenceTime) {
        this.referenceTime = referenceTime;
    }


    public List<TimeSeries> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(List<TimeSeries> timeSeries) {
        this.timeSeries = timeSeries;
    }
}
