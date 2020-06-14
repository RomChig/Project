package com.roma.DAOImpl;

import com.roma.DAO.UserDAO;
import com.roma.models.User;
import com.roma.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDAOImplOnSpring implements UserDAO {
    private UserRepository userRepository;

    @Autowired
    public UserDAOImplOnSpring(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<List<User>> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
