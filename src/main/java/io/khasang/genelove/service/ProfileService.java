package io.khasang.genelove.service;


import io.khasang.genelove.model.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProfileService {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String region;
    private String school;
    private String university;
    private String activity;
    private String hobby;
    private List friendlist;

    public ProfileService() {}

    public ProfileService(String firstName, String lastName, String birthDate, String region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.region = region;
    }

    public List<ProfileService> getFriendsList(){
        friendlist = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            friendlist.add(new ProfileService("friend" + i, "FRIEND" + i,
                    "01-01-1990", "Moscow" + i));
        }
        return friendlist;
    }

    public String getFirstName() {
        firstName = "myName";
        return firstName;
    }

    public String getLastName() {
        lastName = "mySurname";
        return lastName;
    }

    public String getBirthDate() {
        birthDate = "myDate";
        return birthDate;
    }

    public String getRegion() {
        region = "myRegion";
        return region;
    }

    public String getSchool() {
        school = "mySchool";
        return school;
    }

    public String getUniversity() {
        university = "myUniversity";
        return university;
    }

    public String getActivity() {
        activity = "myActivity";
        return activity;
    }

    public String getHobby() {
        hobby = "myHobby";
        return hobby;
    }

    public String getAvatar() {return "resources/smile.jpg";}
}
