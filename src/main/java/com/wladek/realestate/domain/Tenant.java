package com.wladek.realestate.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.Constraint;
import java.util.Date;
import java.util.Set;

/**
 * Created by wladek on 1/1/10.
 */
@Entity
public class Tenant extends AbstractModel {
    private String name;
    private String idNumber;
    private Date admittance;
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "tenant")
    private Set<Shop> shops;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getAdmittance() {
        return admittance;
    }

    public void setAdmittance(Date admittance) {
        this.admittance = admittance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Shop> getShops() {
        return shops;
    }

    public void setShops(Set<Shop> shops) {
        this.shops = shops;
    }
}
