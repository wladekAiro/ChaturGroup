package com.wladek.realestate.service.property;

import com.wladek.realestate.domain.Building;

import java.util.List;

/**
 * Created by wladek on 4/23/16.
 */
public interface BuildingService {
    public Building create(Building building);
    public Building findOne(Long id);
    public List<Building> findAll();
    public Building edit(Building building);
}
