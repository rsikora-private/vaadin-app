package com.sikorasoftware.example1.service;

import org.springframework.stereotype.Service;
import com.sikorasoftware.example1.model.User;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Created by robertsikora on 29.10.15.
 */

@Service
public class UserServiceImpl implements UserService {

    private final static AtomicLong ID = new AtomicLong(0);
    private final static List<User> STORAGE = new ArrayList<>();

    @Override
    public User save(User user) {
        Assert.notNull(user);

        user.setId(ID.getAndIncrement());
        try {
            STORAGE.add(user.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Collection<User> getAllUsers() {
        return STORAGE;
    }

    @Override
    public Collection<User> getAllUsers(final String filter) {
        return STORAGE.stream()
                .filter(t-> t.getFirstName().contains(filter)
                        || t.getLastName().contains(filter)).collect(Collectors.toList());
    }
}
