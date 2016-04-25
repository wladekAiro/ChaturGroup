package com.wladek.realestate.service.property;

import com.wladek.realestate.domain.Property;

import java.util.List;

/**
 * Created by wladek on 1/1/10.
 */
public interface PropertyService {
    public Property  create(Property property);
    public Property findOne(Long id);
    public List<Property> findAll();
    public Property update(Property property);
    public boolean delete(Long id);
}
