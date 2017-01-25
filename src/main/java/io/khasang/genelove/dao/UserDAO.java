package io.khasang.genelove.dao;

import io.khasang.genelove.entity.*;

import java.util.List;

public interface UserDAO {

    void addUser(User user);

    void deleteUser(User user);

    void editUser(User user);

    User getUserByLogin(String login);

    User getUserById(long id);

    List<User> getUserAll();

    void addAuthorisation(User user);

    Role getRoleByName(String name);

    Role getRoleById(long id);

    List<Favourite> getFavouritesForUser(User user);

    void addToFavourites(User currentUser, User favouriteUser);

    void removeFromFavourites(User currentUser, User favouriteUser);

    void update(); // to be removed
}
