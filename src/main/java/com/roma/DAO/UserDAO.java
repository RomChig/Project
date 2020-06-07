package com.roma.DAO;

import com.roma.models.User;

import java.util.Optional;

public interface UserDAO extends DAO<User> {
    Optional<User> findByName(String name);
}
