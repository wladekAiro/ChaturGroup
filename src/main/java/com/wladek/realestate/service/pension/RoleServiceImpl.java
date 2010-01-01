package com.wladek.realestate.service.pension;

import com.wladek.realestate.domain.Role;
import com.wladek.realestate.repository.pension.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by wladek on 11/24/15.
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Transactional
    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    @Override
    public Role getOne(Long roleId) {
        return roleRepository.findOne(roleId);
    }

    @Transactional
    @Override
    public void delete(Long roleId) {
        roleRepository.delete(roleId);
    }

    @Transactional
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
