package com.wladek.realestate.service.property;

import com.wladek.realestate.domain.Floor;

import java.util.List;

/**
 * Created by wladek on 4/26/16.
 */
public interface FloorService {
    public Floor create(Floor floor);
    public Floor findOne(Long id);
    public List<Floor> getAll();
    public Floor edit(Floor floor);
}
