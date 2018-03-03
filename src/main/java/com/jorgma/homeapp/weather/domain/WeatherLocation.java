package com.jorgma.homeapp.weather.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jorgma on 2018-02-20.
 */
@Entity(name = "weather_locations")
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherLocation {

    @Id
    @GeneratedValue
    private int id;
    private int geoNameId;
    private String place;
    private int population;
    private double longitude;
    private double latitude;
    private String municipality;
    private String country;
    private String district;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeoNameId() {
        return geoNameId;
    }

    @JsonSetter("geonameid")
    public void setGeoNameId(int geoNameId) {
        this.geoNameId = geoNameId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLongitude() {
        return longitude;
    }

    @JsonSetter("lon")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    @JsonSetter("lat")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
