package com.wladek.realestate.domain;

import javax.persistence.Entity;

/**
 * Created by wladek on 1/1/10.
 */
@Entity
public class Building extends AbstractModel{
    private String name;
    private String location;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
