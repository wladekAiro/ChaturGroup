package com.wladek.realestate.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by wladek on 1/1/10.
 */

/*This class represents the different companies
 */
@Entity
@Table(name = "property")
public class Property extends AbstractModel {
    @NotEmpty(message = "Provide company name")
    private String name;
    @Column(columnDefinition = "text")
    @NotEmpty(message = "Provide a brief description")
    private String description;

    @OneToMany(mappedBy = "property",fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    private Set<Building> buildings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }
}
