package io.khasang.genelove.entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Personal info
 * @author Denis Guzikov
 * @version 1.0
 */

public class PersInfo {
    public PersInfo() {
    }

    @Id
    private long id;
    /** Field "about me" */
    private String info;
    /** Field "who I seek" */
    private String lookingFor;
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    private Person person;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
