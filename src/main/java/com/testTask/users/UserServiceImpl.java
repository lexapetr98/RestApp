package com.testTask.users;

import com.testTask.users.Interface.UserDAO;
import com.testTask.users.Interface.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void create(final User user) {
        userDAO.save(user);
    }

    @Override
    public List<User> readAll() {
        return userDAO.findAll();
    }

    @Override
    public User read(final int id) {
        return userDAO.getById(id);
    }

    @Override
    public boolean update(final User user, final int id) {
        if (userDAO.existsById(id)) {
            User userExist = userDAO.getById(id);
            userExist.setUserID(id);
            userExist.setUserName(user.getUserName());
            userExist.setUserPassword(user.getUserPassword());
            userDAO.save(userExist);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(final int id) {
        if (userDAO.existsById(id)) {
            userDAO.deleteById(id);
            return true;
        }
        return false;
    }
}
