package com.iitgn.entryexit.services;

import com.iitgn.entryexit.entities.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(Long Id);
}
