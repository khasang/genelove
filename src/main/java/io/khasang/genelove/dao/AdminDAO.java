package io.khasang.genelove.dao;

import io.khasang.genelove.entity.User;
import io.khasang.genelove.entity.Role;

import java.util.List;

public interface AdminDAO {

    long getAllUsersCount();

    long getRoleId(String role);

    boolean checkUserRole(User user, Role role);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    void createRole(Role role);

    void addRole(User user, Role role);

    void removeRole(User user, Role role);

    User getUserById(long id);

    User getUserByLogin(String login);

    List<User> getUsers();

    List<User> filterUsers(String filter);

    Role getRoleById(long id);

    Role getRoleByName(Role.RoleName name);

    List<Role> getRoles();

    String getAssocRolesCount(Role role);
}
