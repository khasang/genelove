package io.khasang.genelove.service;

import io.khasang.genelove.dao.AdminDAO;
import io.khasang.genelove.entity.Role;
import io.khasang.genelove.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component("AdminService")
@Transactional
public class AdminService {

    @Autowired
    AdminDAO adminDAO;

    public long getAllUsersCount() {
        return adminDAO.getAllUsersCount();
    }

    public List<User> getUsers() {
        return adminDAO.getUsers();
    }

    public List<User> filterUsers(String filter) {
        return adminDAO.filterUsers(filter);
    }

    public List<Role> getRoles() {
        return adminDAO.getRoles();
    }

    public int getRoleId(String role) { return adminDAO.getRoleId(role); }

    public boolean checkUserRole(User user, Role role) { return adminDAO.checkUserRole(user, role); }

    public void addRole(User user, Role role) { adminDAO.addRole(user, role); }

    public void removeRole(User user, Role role) { adminDAO.removeRole(user, role); }

    public User getUserById(int id) {
        return adminDAO.getUserById(id);
    }

    public User getUserByLogin(String login) {
        return adminDAO.getUserByLogin(login);
    }

    public Role getRoleById(int id) {
        return adminDAO.getRoleById(id);
    }

    public Role getRoleByName(Role.RoleName name) {
        return adminDAO.getRoleByName(name);
    }

    public void addUser(User user) {
        adminDAO.addUser(user);
    }

    public void deleteUser(User user) {
        adminDAO.deleteUser(user);
    }

    public void updateUser(User user) {
        adminDAO.updateUser(user);
    }

    public String getAssocRolesCount(Role role) {
        return adminDAO.getAssocRolesCount(role);
    }

    public void createAllRoles() {
        for (Role.RoleName roleName : Role.RoleName.values()) {
            if (adminDAO.getRoleByName(roleName) == null) {
                Role role = new Role();
                role.setRoleName(roleName);
                adminDAO.createRole(role);
            }
        }
    }
}
