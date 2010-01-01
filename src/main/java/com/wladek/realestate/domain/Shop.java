package com.wladek.realestate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by wladek on 1/1/10.
 */
@Entity
public class Shop extends AbstractModel {
    private String number;
    @Column(columnDefinition = "text")
    private String description;

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
}
