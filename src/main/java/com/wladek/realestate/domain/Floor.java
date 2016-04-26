package com.wladek.realestate.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wladek on 1/1/10.
 */
@Entity
public class Floor extends AbstractModel {
    @NotEmpty(message = "Please provide floor number/name")
    private String number;
    @NotEmpty(message = "Please provide floor description")
    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;

    @OneToMany(mappedBy = "floor" , fetch = FetchType.LAZY)
    private Set<Shop> shops;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }

    @Transient
    private Long buildingId;

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }
}
