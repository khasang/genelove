package io.khasang.genelove.dao;

import io.khasang.genelove.entity.Profile;
import io.khasang.genelove.entity.User;

import java.util.Date;
import java.util.List;

public interface ProfileDAO {

    void addProfile(Profile profile, User user);

    List<Profile> getUserProfiles (User user);

    Profile getProfileById (long id);

    void updateProfile(Profile profile, User user);

    void hideProfile(Profile profile);

    void shareProfile(Profile profile);

    List<Profile> getProfiles(Date dateFrom, Date dateTo, Profile.Gender gender, Profile.MaritalStatus maritalStatus, User user);
}
