package com.wladek.realestate.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wladek on 1/1/10.
 */
@Entity
public class Building extends AbstractModel{
    private String name;
    private String location;
    private String address;

    @Transient
    private Long propertyId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Property property;

    @OneToMany(mappedBy = "building" , fetch = FetchType.LAZY)
    private Set<Floor> floors;

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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
}
