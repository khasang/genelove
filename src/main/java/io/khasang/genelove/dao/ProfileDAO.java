package io.khasang.genelove.dao;

import io.khasang.genelove.entity.Profile;
import io.khasang.genelove.entity.User;

import java.util.List;

public interface ProfileDAO {

    void addProfile(Profile profile, User user);

    List<Profile> getUserProfiles (User user);

    Profile getProfileById (int id);

    void editProfile(Profile profile);

    void hideProfile(Profile profile);

    void shareProfile(Profile profile);

    List<Profile> getProfiles(int ageFrom, int ageTo, String gender);
}
