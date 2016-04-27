package com.wladek.realestate.service.property;

import com.wladek.realestate.domain.Building;
import com.wladek.realestate.domain.Floor;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by wladek on 4/26/16.
 */
public interface FloorService {
    public Floor create(Floor floor);
    public Floor findOne(Long id);
    public List<Floor> getAll();
    public Floor edit(Floor floor);
    public Page<Floor> findByBuilding(Building building, int page , int size);
}
