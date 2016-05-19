package com.wladek.realestate.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wladek on 1/1/10.
 */
@Entity
public class Building extends AbstractModel{
    @NotEmpty(message = "Provide name")
    private String name;
    @NotEmpty(message = "Provide location")
    private String location;
    @NotEmpty(message = "Provide address")
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
