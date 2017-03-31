package com.hibernate.demo;

import javax.persistence.Embeddable;

/**
 * Created by priyanka on 26/3/17.
 */
@Embeddable
public class Address {

    String streetNumber;
    String location;
    String state;

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
