package io.khasang.genelove.service;


import io.khasang.genelove.model.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProfileService {
    private String firstName = "myName";
    private String lastName = "mySurname";
    private String birthDate  = "myDate";
    private String region = "myRegion";
    private String school = "mySchool";
    private String university = "myUniversity";
    private String activity = "myActivity";
    private String hobby = "myHobby";
    private List friendlist = new ArrayList<>();

    public ProfileService() {
        for (int i = 0; i < 6; i++) {
            friendlist.add(new ProfileService("friend" + i, "FRIEND" + i,
                    "01-01-1990", "Moscow" + i));
        }
    }

    public ProfileService(String firstName, String lastName, String birthDate, String region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.region = region;
    }

    public List<ProfileService> getFriendsList(){
        return friendlist;
    }

    public String getFirstName() {
       return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getRegion() {
        return region;
    }

    public String getSchool() {
        return school;
    }

    public String getUniversity() {
        return university;
    }

    public String getActivity() {
        return activity;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAvatar() {return "resources/smile.jpg";}
}
