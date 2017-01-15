package io.khasang.genelove.service;


import io.khasang.genelove.model.UserProfile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProfileService {

    public List<UserProfile> getFriendsList(String login){
        return new ArrayList<>();
    }

    public String getFirstName() {
        return "myName";
    }

    public String getLastName() {
        return "mySurname";
    }

    public String getBirthDate() {
        return "date";
    }

    public String getRegion() {
        return "region";
    }

    public String getSchool() {
        return "school";
    }

    public String getUniversity() {
        return "university";
    }

    public String getActivity() {
        return "activity";
    }

    public String getHobby() {
        return "hobby";
    }
}
