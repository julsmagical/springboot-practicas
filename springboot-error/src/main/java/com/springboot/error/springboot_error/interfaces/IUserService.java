package com.springboot.error.springboot_error.interfaces;

import java.util.List;
import java.util.Optional;

import com.springboot.error.springboot_error.models.domain.User;

public interface IUserService {

    Optional<User> getById(Long id);
    List<User> getAll();
}
