package io.khasang.genelove.service;

import io.khasang.genelove.dao.AdminDAO;
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

    public List<User> getUsersList() {
        return adminDAO.getUsersList();
    }
}
