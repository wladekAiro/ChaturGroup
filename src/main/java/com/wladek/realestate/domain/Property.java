package com.wladek.realestate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by wladek on 1/1/10.
 */

/*This class represents the different companies
 */
@Entity
@Table(name = "property")
public class Property extends AbstractModel {
    private String name;
    @Column(columnDefinition = "text")
    private String description;

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
}
