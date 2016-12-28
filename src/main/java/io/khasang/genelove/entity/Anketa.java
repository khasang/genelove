package io.khasang.genelove.entity;

import javax.persistence.Id;
import java.util.Date;

/**
 * Личная информация
 * @author Denis Guzikov
 * @version 1.0
 */

public class Anketa {
    public Anketa() {
    }

    @Id
    private long id;
    /** Поле "о себе" */
    private String info;
    /** Поле "кого я ищу" */
    private String lookingFor;   //кого я ищу
    private String phone;
    private String email;
    private String address;
    private long personId;

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

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
