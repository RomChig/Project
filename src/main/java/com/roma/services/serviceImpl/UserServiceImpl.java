package com.roma.services.serviceImpl;

import com.roma.DAO.UserDAO;
import com.roma.DAOImpl.UserDaoImpl;
import com.roma.models.User;
import com.roma.services.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService<User> {

    private static final UserDAO userDAO = new UserDaoImpl();

    @Override
    public Optional<List<User>> findByName(String name) {
        return userDAO.findByName(name);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
