package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Родители
 * @author Denis Guzikov
 * @version 1.0
 */

@Entity
public class Parent {
    public Parent() {
    }

    @Id
    private long id;
    /** Поле "потомок" */
    private long personId;
    /** Поле "родитель(предок)" */
    private long personParentId;
    /** Поле "тип" (мама или папа) */
    private int type;

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
