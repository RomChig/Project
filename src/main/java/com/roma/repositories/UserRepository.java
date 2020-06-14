package com.roma.repositories;

import com.roma.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByNameAndAge(String name, Long age);

    Optional<List<User>> findByName(String name);

}
