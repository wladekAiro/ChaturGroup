package com.wladek.realestate.service.property;

import com.wladek.realestate.domain.Building;
import com.wladek.realestate.repository.BuildingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wladek on 4/23/16.
 */
@Service
public class BuildingServiceImpl implements BuildingService{
    @Autowired
    private BuildingRepo buildingRepo;
    @Autowired
    private PropertyService propertyService;

    @Override
    public Building create(Building building) {
        building.setProperty(propertyService.findOne(building.getPropertyId()));
        return buildingRepo.save(building);
    }

    @Override
    public Building findOne(Long id) {
        return buildingRepo.findOne(id);
    }

    @Override
    public List<Building> findAll() {
        return buildingRepo.findAll();
    }

    @Override
    public Building edit(Building building) {
        return null;
    }
}
