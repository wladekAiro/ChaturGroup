package com.wladek.realestate.service.pension;

import com.wladek.realestate.domain.Role;

import java.util.List;

/**
 * Created by wladek on 11/24/15.
 */
public interface RoleService {
    public Role create(Role role);
    public Role getOne(Long roleId);
    public void delete(Long roleId);
    public List<Role> findAll();
}
