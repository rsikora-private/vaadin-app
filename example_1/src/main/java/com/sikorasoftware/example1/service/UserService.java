package com.sikorasoftware.example1.service;

import com.sikorasoftware.example1.model.User;

import java.util.Collection;

/**
 * Created by robertsikora on 29.10.15.
 */
public interface UserService {

    User save(User user);
    Collection<User> getAllUsers();
}
