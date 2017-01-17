package io.khasang.genelove.service;

import io.khasang.genelove.dao.AdminDAO;
import io.khasang.genelove.entity.Role;
import io.khasang.genelove.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

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

    public int getRoleId(String role) { return adminDAO.getRoleId(role); }

    public boolean checkUserRole(User user, Role role) { return adminDAO.checkUserRole(user, role); }

    public void addRole(User user, Role role) { adminDAO.addRole(user, role); }

    public void removeRole(User user, Role role) { adminDAO.removeRole(user, role); }

    public List<User> getUserById(int id) {
        List<User> users = new ArrayList<>();
        users.add(adminDAO.getUserById(id));
        return users;
    }

    public List<User> getUserByLogin(String login) {
        List<User> users = new ArrayList<>();
        users.add(adminDAO.getUserByLogin(login));
        return users;
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

}
