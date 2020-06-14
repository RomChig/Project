package com.roma.DAO;

import com.roma.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO extends DAO<User> {
    Optional<List<User>> findByName(String name);
}
