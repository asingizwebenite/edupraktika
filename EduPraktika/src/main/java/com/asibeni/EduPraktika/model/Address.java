package com.asibeni.EduPraktika.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String district;
    private String sector;
    private String country;
    private String city;

    public Address() {}
    public Address(String district, String sector, String country, String city) {
        this.district = district;
        this.sector = sector;
        this.country = country;
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String streetNo) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
