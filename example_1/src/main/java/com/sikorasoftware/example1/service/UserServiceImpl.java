package com.sikorasoftware.example1.service;

import org.springframework.stereotype.Service;
import com.sikorasoftware.example1.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by robertsikora on 29.10.15.
 */

@Service
public class UserServiceImpl implements UserService {

    private final static AtomicLong ID = new AtomicLong(0);
    private final static List<User> STORAGE = new ArrayList<>();

    @Override
    public User save(User user) {
        user.setId(ID.getAndIncrement());
        STORAGE.add(user);
        return user;
    }

    @Override
    public Collection<User> getAllUsers() {
        return STORAGE;
    }
}
