package com.wladek.realestate.service.property;

import com.wladek.realestate.domain.Property;
import com.wladek.realestate.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wladek on 1/1/10.
 */
@Service
public class PropertyServiceImpl implements PropertyService{
    @Autowired
    private PropertyRepo propertyRepo;

    @Override
    public Property create(Property property) {
        return propertyRepo.save(property);
    }

    @Override
    public Property findOne(Long id) {
        return propertyRepo.findOne(id);
    }

    @Override
    public List<Property> findAll() {
        return propertyRepo.findAll();
    }

    @Override
    public Property update(Property property) {
        Property propertyInDb = findOne(property.getId());
        propertyInDb.setName(property.getName());
        propertyInDb.setDescription(property.getDescription());
        return propertyRepo.save(propertyInDb);
    }

    @Override
    public boolean delete(Long id) {
        propertyRepo.delete(id);
        return true;
    }
}

