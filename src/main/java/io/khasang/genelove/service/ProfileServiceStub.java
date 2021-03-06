package io.khasang.genelove.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*
    Stub class for profile & findFriends jsp
 */
@Service
@Transactional
public class ProfileServiceStub {
    private String firstName = "myName";
    private String lastName = "mySurname";
    private String birthDate  = "myDate";
    private String region = "myRegion";
    private String school = "mySchool";
    private String university = "myUniversity";
    private String activity = "myActivity";
    private String hobby = "myHobby";
    private List friendlist = new ArrayList<>();

    public ProfileServiceStub() {
        for (int i = 0; i < 6; i++) {
            friendlist.add(new ProfileServiceStub("friend" + i, "FRIEND" + i,
                    "01-01-1990", "Moscow" + i));
        }
    }

    public ProfileServiceStub(String firstName, String lastName, String birthDate, String region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.region = region;
    }

    public List<ProfileServiceStub> getFriendsList(){
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

