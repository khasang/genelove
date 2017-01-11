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
    private Relative relative;
    /** Field "parent(progenitor)" */
    @ManyToOne
    private Relative relativeParent;
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

    public Relative getRelative() {
        return relative;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
    }

    public Relative getRelativeParent() {
        return relativeParent;
    }

    public void setRelativeParent(Relative relativeParent) {
        this.relativeParent = relativeParent;
    }
}
