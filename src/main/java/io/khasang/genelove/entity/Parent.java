package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Denis Guzikov
 * Date 26-12-2016
 * Родители
 */

@Entity
public class Parent {
    public Parent() {
    }

    @Id
    private long id;
    private long personId;          //потомок
    private long personParentId;    //родитель(предок)
    private int type;               //мама или папа

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public long getPersonParentId() {
        return personParentId;
    }

    public void setPersonParentId(long personParentId) {
        this.personParentId = personParentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
