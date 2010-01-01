package com.wladek.realestate.service;

import com.wladek.realestate.domain.User;

import java.util.List;

/**
 * @author wladek
 */
public interface UserService {

    User addNewUser(User user);

    void login(User user);

    public List<User> findAll();
}
