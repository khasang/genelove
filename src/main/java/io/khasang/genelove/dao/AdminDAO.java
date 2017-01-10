package io.khasang.genelove.dao;

import io.khasang.genelove.entity.User;

import java.util.List;

public interface AdminDAO {
    List<User> getUsersList();

    long getAllUsersCount();
}
