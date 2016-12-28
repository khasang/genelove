package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Relations {

    @Id
    private int id;

    private int relative_id;

    private int role_id;

    public Relations() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRelative_id() {
        return relative_id;
    }

    public void setRelative_id(int relative_id) {
        this.relative_id = relative_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
