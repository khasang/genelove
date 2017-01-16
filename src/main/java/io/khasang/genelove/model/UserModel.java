package io.khasang.genelove.model;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class UserModel {
    private String name;
    private String surName;
    private String nickName;
    private String gender;
    private int age;
    private JdbcTemplate jdbcTemplate;

    public UserModel(String name, String surName, String nickName, String gender, int age) {
        this.name = name;
        this.surName = surName;
        this.nickName = nickName;
        this.gender = gender;
        this.age = age;
    }

    public UserModel() {
        this.name = null;
        this.surName = null;
        this.nickName = null;
        this.gender = null;
        this.age = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String userInformation () {
        try {
            String result = jdbcTemplate.queryForObject
                    ("SELECT * FROM userInfo WHERE id = 1", String.class);
            return "result: " + result.toString();
        }
        catch (Exception e) {
            return "Data simple select from userInfo failed: " + e;
        }
    }

    public String userInfoStatus () {
        return userInformation();
    }
}
