package com.wladek.realestate.service.property;

import com.wladek.realestate.domain.Floor;
import com.wladek.realestate.repository.FloorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wladek on 4/26/16.
 */
@Service
public class FloorServiceImpl implements FloorService{
    @Autowired private FloorRepo floorRepo;
    @Autowired private BuildingService buildingService;

    @Override
    public Floor create(Floor floor) {
        floor.setBuilding(buildingService.findOne(floor.getBuildingId()));
        return floorRepo.save(floor);
    }

    @Override
    public Floor findOne(Long id) {
        return floorRepo.findOne(id);
    }

    @Override
    public List<Floor> getAll() {
        return floorRepo.findAll();
    }

    @Override
    public Floor edit(Floor floor) {

        Floor floorInDb = findOne(floor.getId());

        floorInDb.setNumber(floor.getNumber());
        floorInDb.setDescription(floor.getDescription());

        return floorRepo.save(floorInDb);
    }
}
