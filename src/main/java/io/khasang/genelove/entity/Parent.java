package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Parents
 * @author Denis Guzikov
 * @version 1.0
 */

@Entity
public class Parent {
    public Parent() {
    }

    @Id
    private long id;
    /** Field "child" */
    @ManyToOne
    private Person person;
    /** Field "parent(progenitor)" */
    @ManyToOne
    private Person personParent;
    /** Field "type" (mother or father) */
    private int type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPersonParent() {
        return personParent;
    }

    public void setPersonParent(Person personParent) {
        this.personParent = personParent;
    }
}
