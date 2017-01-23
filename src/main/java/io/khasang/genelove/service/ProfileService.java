package io.khasang.genelove.service;

import io.khasang.genelove.dao.ProfileDAO;
import io.khasang.genelove.dao.UserDAO;
import io.khasang.genelove.entity.Profile;
import io.khasang.genelove.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ProfileService {

    @Autowired
    ProfileDAO profileDAO;

    @Autowired
    UserDAO userDAO;

    public void addProfile(Profile profile) {
        User user = userDAO.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        profileDAO.addProfile(profile, user);
    }

    public List<Profile> getUserProfiles (User user) {
        return profileDAO.getUserProfiles(user);
    }

    public Profile getProfileById (int id) {
        return profileDAO.getProfileById(id);
    }

    public void updateProfile(Profile profile) {
        profileDAO.updateProfile(profile);
    }

    public void hideProfile(Profile profile) {
        profileDAO.hideProfile(profile);
    }

    public void shareProfile(Profile profile) {
        profileDAO.shareProfile(profile);
    }

    public List<Profile> getProfiles(int ageFrom, int ageTo, String gender, String marital){
        User user = userDAO.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        return profileDAO.getProfiles(ageFrom, ageTo, gender, marital, user);
    }

}
