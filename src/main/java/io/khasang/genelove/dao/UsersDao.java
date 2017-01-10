package io.khasang.genelove.dao;

import io.khasang.genelove.entity.Credentials;

import java.util.List;

public interface UsersDao {
    void addUser(Credentials credentials);
    void updateUser(Credentials credetial);
    void deleteUser(Credentials credentials);
    Credentials getUserById(int id);
    List<?> getUsers();
}
