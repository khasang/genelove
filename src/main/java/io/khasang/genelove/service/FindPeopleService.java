package io.khasang.genelove.service;

import io.khasang.genelove.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FindPeopleService {

    public List<ProfileService> findPeople(String firstName, String lastName, String region, String id) {
        List<ProfileService> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new ProfileService(firstName + i,lastName + i,"02/02/1991",id + i));
        }
        return list;
    }
}
