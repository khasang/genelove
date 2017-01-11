package io.khasang.genelove.dao;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.entity.Role;

import java.util.List;

public interface AdminDAO {

    List<User> getUsersList();

    long getAllUsersCount();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    void addRole(User user, Role role);

    void removeRole(User user, Role role);

    User getUserById(int id);

    User getUserByLogin(String login);

    List<User> getUsers();
}