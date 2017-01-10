package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * People - basis of the family tree
 * @author Denis Guzikov
 * @version 1.0
 */
@Entity
public class Person {
    public Person() {
    }

    @Id
    private long id;
    private String firstName;
    private String secondName;
    private String middleName;
    /** Field "BirthDay" */
    private Date startDate;
    private Date endDate;
    @ManyToOne
    private Users user;
    private String info;
    private boolean thisUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public boolean isThisUser() {
        return thisUser;
    }

    public void setThisUser(boolean thisUser) {
        this.thisUser = thisUser;
    }
}
