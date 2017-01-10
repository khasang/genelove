package io.khasang.genelove.service;

import io.khasang.genelove.dao.UsersDao;
import io.khasang.genelove.entity.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UsersService {
    @Autowired
    UsersDao usersDao;

    public void addUser(Credentials credentials) {
        usersDao.addUser(credentials);
    }

    public Credentials getUserById(int id) {
        return usersDao.getUserById(id);
    }

    public List<?> getUsersList() {
        return usersDao.getUsers();
    }

    public void updateUser(Credentials credentials) {
        usersDao.updateUser(credentials);
    }

    public void deleteUsers(Credentials credentials) {
        usersDao.deleteUser(credentials);
    }
}
