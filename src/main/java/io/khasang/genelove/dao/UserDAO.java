package io.khasang.genelove.dao;

import io.khasang.genelove.entity.*;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void deleteUser(User user);

    void editUser(User user);

    User getUserByLogin(String login);

    User getUserById(int id);

    List<User> getUserAll();

    void addAuthorisation(User user);

    Role getRoleByName(String name);

    Role getRoleById(int id);

    void addFavourite(User user, User favourite);

    void deleteFavourite(User user, User favourite);

    void update(); // to be removed
}
