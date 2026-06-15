package com.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.error.springboot_error.interfaces.IUserService;
import com.springboot.error.springboot_error.models.domain.User;

@Service
public class UserService implements IUserService {

    @Autowired
    private List<User> users;

    @Override
    public Optional<User> getById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    @Override
    public List<User> getAll() {
        return users;
    }

}
