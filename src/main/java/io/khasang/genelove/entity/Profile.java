package io.khasang.genelove.entity;

import javax.persistence.*;
import java.util.Date;

/** Class that is used by Hibernate to create table "profiles" in the Database.
 * Table is used to store personal information(profiles) about registered users.
 *
 * Класс, используя который, Hibernate создаёт таблицу в Базе данных.
 * В таблице хранится персональная информация(анкеты) о зарегистрированных пользователях. */

@Entity(name = "profiles")
public class Profile {

    public enum Gender {
        FEMALE, MALE, OTHER
    }

    public enum MaritalStatus {
        SINGLE, MARRIED, SEPARATED, DIVORCED, WIDOWED, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "profiles_users_fk"))
    private User user;

    @Column(name = "nickname", length = 255)
    private String nickname;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "marital_status", nullable = false)
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

    public Profile() {
        this.gender = Gender.OTHER;
        this.maritalStatus = MaritalStatus.OTHER;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
