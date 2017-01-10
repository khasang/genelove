package io.khasang.genelove.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles {
    @Id
    private int id;
    private String role_name;

    public Roles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
