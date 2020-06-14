package com.roma.services;

import com.roma.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService<T> {
    Optional<List<T>> findByName(String name);

    Optional<T> findById(Long id);

    void save(User user);

    void delete(User user);

    void update(User user);
}
