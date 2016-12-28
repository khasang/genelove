package io.khasang.genelove.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Users_Details {
    @Id
    private long user_id;
    @Column
    private String FirstName;
    private String SurName;
    private String LastName;
    private Date Date_of_Birth;
    private Date Date_of_Deatb;
    //
    public Users_Details() {
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getDate_of_Birth() {
        return Date_of_Birth;
    }

    public void setDate_of_Birth(Date date_of_Birth) {
        Date_of_Birth = date_of_Birth;
    }

    public Date getDate_of_Deatb() {
        return Date_of_Deatb;
    }

    public void setDate_of_Deatb(Date date_of_Deatb) {
        Date_of_Deatb = date_of_Deatb;
    }
}
