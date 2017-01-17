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

    void addAuthorisation(User user, Role role);

    Role getRoleByName(String name);

    Role getRoleById(int id);

    void addFavourite(User user, Favourite favourite);

    void deleteFavourite(User user, Favourite favourite);


}
