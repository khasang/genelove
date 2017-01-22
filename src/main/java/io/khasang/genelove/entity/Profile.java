package io.khasang.genelove.entity;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity(name = "profiles")
public class Profile {

    public enum Gender {
        FEMALE, MALE, OTHER
    };

    public enum MaritalStatus {
        SINGLE, MARRIED, SEPARATED, DIVORCED, WIDOWED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "profiles_users_fkey"))
    private User user;

    @Column(name = "nickname", length = 255)
    private String nickname;

    @Column
    private int age;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "marital_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column
    private String hobbies; // can be moved into a separate table

    @Column(length = 1500)
    private String introduction;

    @Column(length = 1500)
    private String match;

    @Column(name = "photo_url")
    private String photoURL;

    @OneToOne(targetEntity = Tree.class)
    @JoinColumn(name = "tree_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "users_trees_fkey"))
    private Tree tree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}
