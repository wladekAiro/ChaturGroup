package com.wladek.realestate.domain.realestate;

import com.wladek.realestate.domain.AbstractModel;

import javax.persistence.Entity;

/**
 * Created by wladek on 11/22/15.
 */
@Entity
public class Pensioner extends AbstractModel{
    private String name;
    private String alias;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
